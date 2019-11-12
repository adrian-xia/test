package jvm.chapter08;

/**
 * 静态分派的典型应用是方法重载
 * 静态分派发生在编译期间
 * Created by xialei on 2017/3/27.
 */
public class StaticDispatch {
    private static abstract class Human {
    }

    private static class Man extends Human {
    }

    private static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("Hello, guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello, gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello((Man) man);
        sr.sayHello(woman);
    }
}
