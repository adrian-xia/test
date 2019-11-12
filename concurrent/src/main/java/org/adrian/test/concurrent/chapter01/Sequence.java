package org.adrian.test.concurrent.chapter01;

import org.adrian.test.concurrent.common.annotation.ThreadSafe;

@ThreadSafe
public class Sequence {

    private int value;

    public synchronized int getNext() {
        return value++;
    }

}
