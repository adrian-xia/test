package jvm.chapter02.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * JAVA堆溢出
 *
 -Xms20M        堆最小
 -Xmx20M        堆最大
 -Xmn10M        堆年轻代大小
 -XX:+PrintGCDetails    打印GC详细信息
 -XX:SurvivorRatio=8    Eden区与Survivor区的大小比值
 -XX:+HeapDumpOnOutOfMemoryError    当堆出现OOM时, 输出dump文件
 */
public class HeapOOM {

    private static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
//            System.out.println(list.size());
        }
    }
}
