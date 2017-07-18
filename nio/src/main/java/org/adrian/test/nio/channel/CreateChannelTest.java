package org.adrian.test.nio.channel;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by xialei on 2017/7/4.
 */
public class CreateChannelTest {

    public static void main(String[] args) throws Exception{
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1", 8080));
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
        DatagramChannel dc = DatagramChannel.open();
        RandomAccessFile raf = new RandomAccessFile("/Users/xialei/start_db.sh", "rw");

    }

}
