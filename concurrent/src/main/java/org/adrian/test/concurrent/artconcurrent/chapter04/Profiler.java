package org.adrian.test.concurrent.artconcurrent.chapter04;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

    @Test
    public void test1() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal.get();
        threadLocal.set(2);
        threadLocal.get();
        ClassLoader classLoader = this.getClass().getClassLoader();


        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
                threadLocal.set(1);
                threadLocal.get();
                threadLocal.set(2);
                threadLocal.get();
            }
        }).start();
    }

}
