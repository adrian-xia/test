package org.adrian.test.serialize.fastjson;

import com.alibaba.fastjson.JSON;
import org.adrian.test.serialize.model.User;

public class FastjsonSerialize {

    public static void main(String[] args) {
        new FastjsonSerialize().start();
    }

    public void start() {
        User user = User.generate();
        byte[] writeValueAsBytes = null;
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            writeValueAsBytes = JSON.toJSONBytes(user);
        }
        System.out.println("fastjson serialize: " + (System.currentTimeMillis() - t1) + "ms; 总大小：" + writeValueAsBytes.length);
        Long t2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            user = JSON.parseObject(writeValueAsBytes, User.class);
        }
        System.out.println("fastjson deserialize: " + (System.currentTimeMillis() - t2) + "ms; User: " + user);
    }
}
