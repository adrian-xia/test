package jvm.chapter07;

/**
 * Created by xialei on 2017/3/24.
 */
public class ConstClass {

    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLO_WORLD = "Hello World";

}
