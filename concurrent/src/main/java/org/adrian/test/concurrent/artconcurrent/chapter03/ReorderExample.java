package org.adrian.test.concurrent.artconcurrent.chapter03;


public class ReorderExample {

    int a = 0;

    boolean flag = false;

    public void writer() throws Exception {
        Thread.sleep(23);
        a = 1;                      //1
        flag = true;                //2
    }

    public void reader() {
        if (flag) {
            int i = a * a;
            System.out.println("i = " + i);
        }
    }

}
