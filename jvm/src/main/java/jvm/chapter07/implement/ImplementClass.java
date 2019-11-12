package jvm.chapter07.implement;

/**
 * 当实现的两个接口都含有相同的常量, 若是使用实现类直接引用继承的常亮则无法编译
 * 如下
 * Created by xialei on 2017/3/24.
 */
public class ImplementClass implements Interface01, Interface02 {

    public static void main(String[] args) {
        System.out.println(Interface01.value);
        System.out.println(Interface02.value);
//        System.out.println(ImplementClass.value);
    }

}
