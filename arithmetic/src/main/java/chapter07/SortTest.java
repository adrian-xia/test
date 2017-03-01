package chapter07;

import java.util.Collection;

/**
 * Created by xialei on 2017/2/28.
 */
public class SortTest {

    /**
     * 插入排序
     * for最后一次的j--会将j赋值后循环结束
     *
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 希尔排序
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                T tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] {50, 29, 47, 86, 30};
        shellSort(a);
        for (Integer i : a) {
            System.out.println(i + ",");
        }
    }

}
