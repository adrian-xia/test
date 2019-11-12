package org.adrian.test.concurrent.artconcurrent.chapter04;

/**
 * 当其他线程停止时，daemon线程直接退出，不会再继续执行，并且不会执行finally代码块
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "Daemon runner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
