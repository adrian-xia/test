package org.adrian.test.concurrent.artconcurrent.chapter08;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    /**
     * 同步屏障
     * 参数为屏障拦截的线程数量，
     * 调用CyclicBarrier.await()，表示到达屏障
     * 当到达屏障的线程数量为创建CyclicBarrier的参数数量时，
     * 屏障释放，所有阻塞的线程均开始向下执行
     */
    private static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

}
