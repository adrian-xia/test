package org.adrian.test.concurrent.artconcurrent.chapter07;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    private static int[] value = new int[]{1, 2};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    /**
     * 创建AtomicIntegerArray时，
     * 会将value复制出一份到原子类中，
     * 所以AtomicIntegerArray内的修改，
     * 不会影响源数组
     * @param args
     */
    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0, 3);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }

}
