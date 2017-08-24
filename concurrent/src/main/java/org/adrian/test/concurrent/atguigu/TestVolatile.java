package org.adrian.test.concurrent.atguigu;


/**
 *
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        /**
         * while(true)
         * 执行效率特别快, 以至于没有时间从主线程获取最新数据, 导致flag=true无法读取到
         *
         */
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("====================");
                break;
            }
        }
    }

}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}