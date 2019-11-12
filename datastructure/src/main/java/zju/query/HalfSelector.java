package zju.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * Created by xialei on 2017/3/16.
 */
public class HalfSelector {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(binSearch(list, 5));
    }

    private static int binSearch(List<Integer> l, Integer value) {
        int mid = l.size() / 2;
        if (l.get(mid).equals(value)) {
            return mid;
        }
        int start = 0;
        int end = l.size() - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (value < l.get(mid)) {
                end = mid - 1;
            } else if (value > l.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
