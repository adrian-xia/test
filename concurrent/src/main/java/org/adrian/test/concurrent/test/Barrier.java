package org.adrian.test.concurrent.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xl48886
 * @version Id : Barrier, v 0.1 2018/01/11 上午11:47 xl48886 Exp $
 */
public class Barrier {

    private AtomicInteger count;

    public Barrier(int count) {
        this.count = new AtomicInteger(count);
    }

    public void await() throws InterruptedException {
        if (count.getAndDecrement() < 0) {
            Thread.sleep(5000);
            this.notifyAll();
            return;
        }
        this.wait(100000);
    }

    public static void main(String[] args) {
        Barrier barrier = new Barrier(5);
        for (int i = 0; i < 5; i++) {
            Task task = new Task(barrier);
            new Thread(task).start();
        }
    }


}


class Task implements Runnable {

    private Barrier barrier;

    public Task(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            System.out.println("继续执行");
        } catch (Exception e) {

        }
    }
}