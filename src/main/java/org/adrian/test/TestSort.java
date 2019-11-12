package org.adrian.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSort {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(0);
        l.add(3);
        Collections.sort(l);
        System.out.println(l);
    }

    @Test
    public void testDemo() {
        System.out.println("Hello World");
    }

}
