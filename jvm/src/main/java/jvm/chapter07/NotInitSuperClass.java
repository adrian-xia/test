package jvm.chapter07;

/**
 * -XX:+TraceClassLoading
 * 通过数组来引用类, 不会触发此类的初始化
 * 但是会导致该类的加载
 * Created by xialei on 2017/3/24.
 */
public class NotInitSuperClass {

    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
//        sca[0] = new SubClass();
//        sca.toString();
    }
}
