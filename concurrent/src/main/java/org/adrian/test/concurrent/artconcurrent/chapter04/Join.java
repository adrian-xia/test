package org.adrian.test.concurrent.artconcurrent.chapter04;

import java.util.concurrent.TimeUnit;

public class Join {


    /**
     * thread.join方法本质上就是当前线程执行了wait()方法，直至thread执行完毕后调用了notifyAll，当前线程才继续执行
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                /**
                 * join方法:
                 * Thread A; Thread B
                 * A.start()  - >  B.join(). A线程执行过程中调用了b.join()方法
                 * 此时A线程等待B线程执行完毕后，再进行执行
                 * 调用此方法的线程
                 */
                //此处调用前一个线程的join执行，所以当前线程等待，直至thread执行完毕后，再执行后面的操作
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }

}
