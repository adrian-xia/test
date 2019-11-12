package jvm.chapter07;

/**
 * -XX:+TraceClassLoading
 * 此处引用子类为被动引用
 * 对于静态字段, 只有直接定义这个字段的类才会被初始化
 * 因此通过其子类引用父类中定义的静态字段, 只会出发父类的初始化而不会出发子类的初始化
 * 但是会加载子类
 * Created by xialei on 2017/3/24.
 */
public class NotInitSubClass {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
