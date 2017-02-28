package chapter02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 课后练习
 * Created by xialei on 2017/2/27.
 */
public class TestUnit {

    @Test
    public void test1() {
        List<Integer> p = new ArrayList<>();
        p.add(1);
        p.add(3);
        p.add(4);
        p.add(6);
        List<Integer> l = new ArrayList<>();
        l.add(100);
        l.add(200);
        l.add(300);
        l.add(400);
        l.add(500);
        l.add(600);
        l.add(700);
        printLots(l, p);
    }

    /**
     * 此处时间复杂度为O(n),仅迭代p
     * @param l
     * @param p
     * @param <T>
     */
    private static <T> void printLots(List<T> l, List<Integer> p) {
        Iterator<T> itL = l.iterator();
        Iterator<Integer> itP = p.iterator();
        T itemL = null;
        Integer itemP;
        int start = 0;
        while (itL.hasNext() && itP.hasNext()) {
            itemP = itP.next();
            System.out.println("Looking for position " + itemP);
            while (start < itemP && itL.hasNext()) {
                start++;
                itemL = itL.next();
            }
            System.out.println(itemL);
        }
    }
}
