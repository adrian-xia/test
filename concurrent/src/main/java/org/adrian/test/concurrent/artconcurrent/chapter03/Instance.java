package org.adrian.test.concurrent.artconcurrent.chapter03;

public class Instance {

    public static void main(String[] args) {
        Instance instance = InstanceFactory.getInstance();
        System.out.println(instance);
    }
}
