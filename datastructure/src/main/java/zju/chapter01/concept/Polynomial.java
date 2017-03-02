package zju.chapter01.concept;

/**
 * Created by xialei on 2017/3/1.
 */
public class Polynomial {

    /**
     * f(x) = a[0] + a[1]x + ... + a[n-1]x^n-1 + a[n]x^n
     * @param a
     * @param x
     * @return
     */
    public static double function(double[] a, double x) {
        int i;
        double p = a[0];
        for (i = 1; i < a.length; i++) {
            p += a[i] * Math.pow(x, i);//此处math.pow是个很耗时的操作，具有n个乘法操作
        }
        return p;
    }

    /**
     * f(x) = a[0] + x(a[1] + x(...(a[n-1] + x(a[n]))...))
     * @param a
     * @param x
     * @return
     */
    public static double newFunction(double[] a, double x) {
        int i;
        double p = a[a.length - 1];
        for(i = a.length - 1; i > 0; i--){
            p = a[i - 1] + x * p;//此处只有一个乘法操作
        }
        return 0;
    }

    /**
     * 当循环的复杂度一致的时候
     * 看每次循环内的时间消耗，乘法的消耗比较大，
     * newFunction中每次循环内只有一次乘法，所以耗时较少
     * @param args
     */
    public static void main(String[] args) {
        double[] a = new double[10];
        double x = 10;
        long start = System.currentTimeMillis();
        double result = function(a, x);
        long executeTime = System.currentTimeMillis() - start;
        System.out.println("executeTime=" + executeTime + ", result=" + result);
    }

}
