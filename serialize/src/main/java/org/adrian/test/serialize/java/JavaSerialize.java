package org.adrian.test.serialize.java;

import org.adrian.test.serialize.model.User;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerialize {
    public static void main(String[] args) throws Exception {
        new JavaSerialize().start();
    }

    public void start() throws Exception {
        User user = User.generate();
        Long t1 = System.currentTimeMillis();
        ByteArrayOutputStream out = null;
        for (int i = 0; i < 1; i++) {
            out = new ByteArrayOutputStream();
            ObjectOutputStream obj = new ObjectOutputStream(out);
            obj.writeObject(user);
        }
        System.out.println("java serialize: " + (System.currentTimeMillis() - t1) + "ms; 总大小：" + out.toByteArray().length);
        Long t2 = System.currentTimeMillis();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new java.io.ByteArrayInputStream(out.toByteArray())));
        user = (User) ois.readObject();
        System.out.println("java deserialize: " + (System.currentTimeMillis() - t2) + "ms; User: " + user);
    }

}
