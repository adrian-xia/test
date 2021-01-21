package org.adrian.test;

/**
 * @author xl48886
 * @version Id: TestThread, v 0.1 2020/6/5 4:04 下午 xl48886 Exp $
 */
public class TestThread {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            System.out.println(i);
            new Thread(() -> {
                try {
                    Thread.sleep(100000);
                } catch (Exception e) {

                }
            }).start();
        }


    }

}
