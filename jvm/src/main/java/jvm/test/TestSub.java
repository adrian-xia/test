package jvm.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSub {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });

    }

}

class Super<T> {
    public void test(T arg) {
    }
}

class Sub extends Super<String> {
    @Override
    public void test(String str) {
        System.out.println(str);
    }
}
