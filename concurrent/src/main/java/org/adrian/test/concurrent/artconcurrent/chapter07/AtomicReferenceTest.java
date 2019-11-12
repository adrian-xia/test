package org.adrian.test.concurrent.artconcurrent.chapter07;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    private static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 15);
        User errorUser = new User("error", 20);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi", 17);
        //首先判断是否是该对象，若是则设置，返回true false
        System.out.println(atomicUserRef.compareAndSet(errorUser, updateUser));
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

}
