package zju.chapter01.concept;

/**
 * 循环打印1-N
 * Created by xialei on 2017/3/1.
 */
public class PrintN {

    public static void printNM1(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    /**
     * 使用递归，当深度特别大的时候，会出现栈溢出
     * @param n
     */
    public static void printNM2(int n) {
        if (n != 0) {
            printNM2(n - 1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        printNM2(n);
    }

}
