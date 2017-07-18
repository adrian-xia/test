package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xialei on 2017/7/5.
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> main = new ArrayList<>();
        main.add(0, 0);
        main.add(1, 1);
        main.add(2, 2);
        main.add(3, 3);
        main.add(4, 4);
        main.subList(1, 3);

    }

}
