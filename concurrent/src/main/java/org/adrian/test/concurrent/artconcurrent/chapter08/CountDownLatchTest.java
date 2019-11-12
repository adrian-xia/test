package org.adrian.test.concurrent.artconcurrent.chapter08;

import org.adrian.test.concurrent.artconcurrent.chapter04.SleepUtils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    /**
     * 当CountDownLatch到0的时候，c.await()停止阻塞，继续向下执行
     */
    private static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                SleepUtils.second(1);
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }


}
