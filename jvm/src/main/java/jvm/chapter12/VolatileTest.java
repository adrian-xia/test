package jvm.chapter12;


/**
 * volatile变量自增运算测试
 * 此处当在increase()方法加上synchronized同步修饰符时，改结果为固定的200000
 * 若是不加，则永远小于200000
 * @author xialei
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        synchronized (VolatileTest.class) {
            race++;
        }
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //当活动线程大于1的时候，说明上面开启的线程并未完成
        while(Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(race);
    }

}
