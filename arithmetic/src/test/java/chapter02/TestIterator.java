package chapter02;

import org.junit.Test;

import java.util.*;

/**
 * Created by xialei on 2017/2/22.
 */
public class TestIterator {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("100");
        list.add("200");
        list.add("300");
        list.add("400");
        list.add("500");
        list.add("600");
    }

    /**
     * ERROR[]
     *
     * =]
     */
    @Test
    public void testForeach() {
        for (String s : list) {
            if ("400".equals(s))
                list.remove("400");
        }
    }

    /**
     * OK
     */
    @Test
    public void testIterator() {
        Iterator<String> it = list.iterator();
        list.removeIf( s -> "400".equals(s));
        while (it.hasNext()) {
            if ("400".equals(it.next())) {
                it.remove();
            }
        }
        System.out.println(list.toString());
    }

}
