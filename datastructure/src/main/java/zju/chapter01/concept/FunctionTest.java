package zju.chapter01.concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xialei on 2017/3/9.
 */
public class FunctionTest {

    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> min = l1.size() < l2.size() ? l1 : l2;
        List<Integer> max =  l1 != min ? l1 : l2;
        if (min.size() == 0) {
            return max;
        }
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < min.size(); i++) {
            for (; j < max.size(); j++) {
                if (min.get(i).compareTo(max.get(j)) < 0) {
                    break;
                } else {
                    result.add(max.get(j));
                }
            }
            result.add(min.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(8);
        l1.add(10);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(4);
        l2.add(5);
        l2.add(9);
        l2.add(11);
        List<Integer> result = merge(l1, l2);
        System.out.println(result);
    }
}
