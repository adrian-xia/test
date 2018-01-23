package org.adrian.zookeeper.watcher;

import org.apache.commons.lang3.RandomUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author xl48886
 * @version Id : Master, v 0.1 2018/01/08 下午6:09 xl48886 Exp $
 */
public class Master implements Watcher {

    private ZooKeeper zk;
    private String hostPort;
    private String serverId = Integer.toHexString(RandomUtils.nextInt(1, 100));
    private boolean isLeader = false;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    public void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    public void runFormaster() throws InterruptedException {
        while (true) {
            try {
                zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException e) {
                e.printStackTrace();
            }
            if (checkMaster()) {
                break;
            }
        }
    }

    public boolean checkMaster() throws InterruptedException {
        while (true) {
            try {
                Stat stat = new Stat();
                byte[] data = zk.getData("/master", false, stat);
                isLeader = serverId.equals(new String(data));
                return true;
            } catch (KeeperException.NoNodeException e) {
                return false;
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        Master m = new Master("vm.ubuntu.host:2181");
        m.startZK();
        Thread.sleep(60000);
    }
}
