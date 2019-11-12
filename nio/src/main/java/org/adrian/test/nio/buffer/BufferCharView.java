package org.adrian.test.nio.buffer;

import java.nio.*;

/**
 * Created by xialei on 2017/6/30.
 */
public class BufferCharView {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        byteBuffer.put(0, (byte)0);
        byteBuffer.put(1, (byte)'H');
        byteBuffer.put(2, (byte)0);
        byteBuffer.put(3, (byte)'i');
        byteBuffer.put(4, (byte)0);
        byteBuffer.put(5, (byte)'!');
        byteBuffer.put(6, (byte)0);
        println(byteBuffer);
        println(charBuffer);
    }

    private static void println(Buffer buffer) {
        System.out.println("pos=" + buffer.position()
        + ", limit=" + buffer.limit()
        + ", capacity=" + buffer.capacity()
        + ": '" + buffer.toString() + "'");
    }
}
