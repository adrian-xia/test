package jvm.chapter02.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * JAVA堆溢出
 * Created by xialei on 2017/3/17.
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
