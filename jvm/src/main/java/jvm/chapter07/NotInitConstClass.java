package jvm.chapter07;

/**
 * -XX:+TraceClassLoading
 * 常量在编译阶段会存入调用类的常量池中,
 * 本质上并没有直接引用到定义常量的类,
 * 因此不会触发定义常量的类的初始化
 * 而且ConstClass也没有加载进来
 * Created by xialei on 2017/3/24.
 */
public class NotInitConstClass {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }

}
