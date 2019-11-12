package jvm.chapter08;

import org.junit.Test;

/**
 *
 * Created by xialei on 2017/3/27.
 */
public class PlaceHolder {

    /**
     * 此处placeholder未被回收
     */
    @Test
    public void test1() {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }

    /**
     * 此处placeholder未被回收
     */
    @Test
    public void test2() {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * 此处placeholder被回收
     */
    @Test
    public void test3() {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }

    /**
     * 局部变量未初始化无法使用
     */
    @Test
    public void test4() {
        int a;
//        System.out.println(a);
    }

}
