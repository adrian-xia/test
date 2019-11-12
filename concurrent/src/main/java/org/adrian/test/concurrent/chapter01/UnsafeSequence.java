package org.adrian.test.concurrent.chapter01;

import org.adrian.test.concurrent.common.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {


    private int value;

    public int getNext() {
        return value++;
    }

    // 此处如果使用volatile修饰的话，
    // 适合单线程写，多线程读，
    // 因为volatile修饰，对于其他线程立即可见
    private volatile int value2;

    public int getNextValue2() {
        return value2++;
    }

}
