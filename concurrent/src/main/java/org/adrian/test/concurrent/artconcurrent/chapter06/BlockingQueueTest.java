package org.adrian.test.concurrent.artconcurrent.chapter06;

import org.junit.Test;

import java.util.concurrent.*;

public class BlockingQueueTest {

    /**
     * 使用数组实现的有界阻塞队列
     * 加锁控制入队和出队
     *
     * @throws InterruptedException
     */
    @Test
    public void testArrayBlockingQueue() throws InterruptedException {
        //此处直接开辟数组空间，若是配置太大，则直接撑爆内存
        ArrayBlockingQueue<Byte> queue = new ArrayBlockingQueue<>(Integer.MAX_VALUE);
        //put和take方法，会响应中断
        queue.put((byte) 1);
        System.out.println(queue.take());
        //此处一直阻塞等待插入新值
        System.out.println(queue.take());
    }

    /**
     * 使用链表实现的有界阻塞队列，最大元素数量是Integer.MAX_VALUE
     * 使用putLock和takeLock两个重入锁控制入队和出队
     */
    @Test
    public void testLinkedBlockingQueue() throws InterruptedException {
        //默认使用Integer.MAX_VALUE作为构造器参数
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        queue.put(1);
//        queue.take();
        queue.add(1);//throw IllegalStateException: Queue full
        queue.remove();//throw NoSuchElementException
    }

    /**
     * 内部初始化使用数组进行初始化
     * 使用Integer.MAX_VALUE则会爆内存
     * 因为是无界的，所以put元素的时候，不会对其阻塞，也就不会抛出InterruptedException
     * 但是put元素的时候，还是会对其持有锁进行原子操作
     * put元素的时候，若是数组元素不足，则需要扩容tryGrow(array, cap);
     *
     * @throws InterruptedException
     */
    @Test
    public void testPriorityBlockingQueue() throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.put(2);
        queue.put(1);
        queue.put(3);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    /**
     * 延时队列，无界，内部使用{@link java.util.PriorityQueue}做队列实现，PriorityQueue内部依然是一个数组做实现
     */
    @Test
    public void testDelayQueue() {
//        DelayQueue<DelayTask> queue = new DelayQueue<>();
//        queue.put(new DelayTlask());
//        queue.put(new DelayTask());
    }

    /**
     * 每一个put操作必须等待一个take操作
     *
     * @throws InterruptedException
     */
    @Test
    public void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        queue.put(1);
//        queue.put(1);
        queue.take();
    }

    /**
     * 使用CAS
     */
    @Test
    public void testLinkTransferQueue() throws InterruptedException {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        queue.transfer(1);


    }

/*
    private static class DelayTask implements Delayed {

        private int i;

        public int getI() {
            return i;
        }

        public DelayTask(int i) {
            i = i;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - now(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return this.getDelay()
        }

        private long now() {
            return
        }
    }*/

}
