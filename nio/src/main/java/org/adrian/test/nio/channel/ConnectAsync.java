package org.adrian.test.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectAsync {

    /**
     * 此处连接需要有服务端创建server连接，此处才能连接上
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String host = "192.168.19.138";
        int port = 9080;
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        InetSocketAddress addr = new InetSocketAddress(host, port);
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println("initiating connection");
        sc.connect(addr);
        System.out.println(sc.isConnectionPending());
        System.out.println(sc.finishConnect());
        while (!sc.finishConnect()) {
            doSomethingUseful();
        }
        System.out.println("connection established");
        sc.close();
    }

    private static void doSomethingUseful() {
        System.out.println("doing something useless");
    }


}
