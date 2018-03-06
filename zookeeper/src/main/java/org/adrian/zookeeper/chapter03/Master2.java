package org.adrian.zookeeper.chapter03;

import org.apache.commons.lang3.RandomUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author xl48886
 * @version Id : Master, v 0.1 2018/03/05 下午10:02 xl48886 Exp $
 */
public class Master2 implements Watcher {

    ZooKeeper zk;
    String hostPort;

    String serverId = Integer.toHexString(RandomUtils.nextInt(0, 100));

    public Master2(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws Exception {
        zk.close();
    }

    void runForMaster() throws Exception {
        while (true) {
            try {
                zk.create("/master",//创建节点名称
                        serverId.getBytes(),//serverId
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,//acl为最不安全的
                        CreateMode.EPHEMERAL);//临时节点
                isLeader = true;
                break;
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException.ConnectionLossException e) {

            }
            if (checkMaster()) break;
        }
    }

    static boolean isLeader = false;

    boolean checkMaster() throws KeeperException, InterruptedException {
        while (true) {
            try {
                Stat stat = new Stat();
                byte[] data = zk.getData("/master", false, stat);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                return false;
            } catch (KeeperException.ConnectionLossException e) {

            }
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws Exception {
        Master2 m = new Master2("vm.centos.host:2181");
        m.startZK();
        m.runForMaster();
        if (isLeader) {
            System.out.println("I'm the leader");
            Thread.sleep(10000);
        } else {
            System.out.println("Someone else is the leader");
        }
        m.stopZK();
    }
}
