package org.adrian.zookeeper.chapter03;

import org.apache.commons.lang3.RandomUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author xl48886
 * @version Id : Master, v 0.1 2018/03/05 下午10:02 xl48886 Exp $
 */
public class Master3 implements Watcher {

    ZooKeeper zk;
    String hostPort;

    String serverId = Integer.toHexString(RandomUtils.nextInt(0, 100));

    public Master3(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws Exception {
        zk.close();
    }

    static boolean isLeader;

    AsyncCallback.StringCallback masterCreateCallback = new AsyncCallback.StringCallback() {

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case OK:
                    isLeader = true;
                    break;
                case CONNECTIONLOSS:
                    checkMaster();
                    break;
                default:
                    isLeader = false;
            }
            System.out.println("I'm " + (isLeader ? "" : "not ") + "the leader");
        }
    };

    void runForMaster() {
        zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, masterCreateCallback, null);
    }

    AsyncCallback.DataCallback masterCheckCallback = new AsyncCallback.DataCallback() {
        @Override
        public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case OK:
                    isLeader = new String(data).equals(serverId);
                    return;
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case NONODE:
                    runForMaster();
                    return;
            }
        }
    };

    void checkMaster() {
        zk.getData("/master", false, masterCheckCallback, null);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws Exception {
        Master3 m = new Master3("vm.centos.host:2181");
        m.startZK();
        m.runForMaster();
        m.stopZK();
    }
}
