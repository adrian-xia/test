package org.adrian.test.concurrent.artconcurrent.chapter03;

public class InstanceFactory {

    private static class InstanceHolder {
        private static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }

}
