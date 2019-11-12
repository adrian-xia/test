package org.adrian.test.concurrent.artconcurrent.chapter08;

public class JoinCountDownLatchTest {

    /**
     * 此处使用join做线程通知来完成CountDownLatch的工作
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }

}
