package jvm.chapter06;

/**
 * Created by xialei on 2017/3/24.
 */
public class TestDiv {

    /**
     * 将会输出Infinity
     * 虚拟机对于浮点数的运算，不会抛出异常，但是会出现一个未知的符号
     * 虚拟机中的double0.0与int0的存储方式不同，所以不会抛出异常。
     * 当 0.0 / 0.0 时，输出NaN(非数)
     * 当 1.0 / 0.0 时，输出Infinity(无穷大)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("大整数" + 2147483647);
    }
}
