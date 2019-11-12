package org.adrian.zookeeper.chapter03;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author xl48886
 * @version Id : Master, v 0.1 2018/03/05 下午10:02 xl48886 Exp $
 */
public class Master1 implements Watcher {

    ZooKeeper zk;
    String hostPort;

    public Master1(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws Exception {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws Exception {
        zk.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws Exception {
        Master1 m = new Master1("vm.centos.host:2181");
        m.startZK();
        Thread.sleep(60000);
        m.stopZK();
    }
}
