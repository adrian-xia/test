package org.adrian.test.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

public class ServerSocketChannelTest {

    public static void main(String[]  args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        ServerSocket serverSocket = channel.socket();
        //创建服务端socket绑定端口
        serverSocket.bind(new InetSocketAddress(8888));

        //阻塞状态下接收消息
        serverSocket.accept();

        channel.configureBlocking(false);
        //非阻塞状态下接收消息
        channel.accept();
    }

}
