package org.adrian.zookeeper.chapter03;

import org.apache.commons.lang3.RandomUtils;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author xl48886
 * @version Id : Worker1, v 0.1 2018/03/14 下午4:58 xl48886 Exp $
 */
public class Worker1 implements Watcher {

    private static final Logger LOG = LoggerFactory.getLogger(Worker1.class);

    ZooKeeper zk;
    String hostPort;
    String serverId = Integer.toHexString(RandomUtils.nextInt(0, 100));

    Worker1(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    @Override
    public void process(WatchedEvent e) {
        LOG.info(e.toString() + ", " + hostPort);
    }

    void register() {
        zk.create("/workers/worker-" + serverId,
                "Idle".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                createWorkerCallback, null);
    }

    AsyncCallback.StringCallback createWorkerCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    register();
                case OK:
                    LOG.info("Registered successfully: " + serverId);
                    break;
                case NODEEXISTS:
                    LOG.warn("Already registered: " + serverId);
                default:
                    LOG.error("Something went wrong: " + KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };

    public static void main(String[] args) throws Exception {
        Worker1 w = new Worker1("");
        w.startZK();
        w.register();
        Thread.sleep(30000);
    }

}
