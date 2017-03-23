package jvm.chapter06;

/**
 * Created by adrian on 2017/3/23.
 */
public class TestClass2 {

    public int inc() {

        int x;

        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        TestClass2 o = new TestClass2();
        o.inc();
    }

}
