package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xialei on 2017/7/5.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().exec("pwd");
        Runtime.getRuntime().exec("ls");

        Test.class.getClassLoader();
    }

}
