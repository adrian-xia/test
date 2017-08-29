package org.adrian.test.concurrent.artconcurrent.chapter08;

import org.adrian.test.concurrent.artconcurrent.chapter04.SleepUtils;

import java.util.ServiceLoader;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

    /**
     * 在所有线程均到达屏障时，若是有barrierAction参数，则优先执行barrierAction里的任务
     */
    private static CyclicBarrier c = new CyclicBarrier(2, new Job());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(10);
                    SleepUtils.second(1);
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            System.out.println(20);
            SleepUtils.second(5);
            c.await();
            System.out.println(30);
            SleepUtils.second(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    private static class Job implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
            SleepUtils.second(2);
        }
    }
}
