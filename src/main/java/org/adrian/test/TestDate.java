package org.adrian.test;

import java.util.Date;

public class TestDate {


    public static void main(String[] args) {
        Date current = new Date();
        Date before = new Date(System.currentTimeMillis() - 10000);

        System.out.println(current.before(before));
    }



}
