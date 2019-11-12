package org.adrian.test.redis.redisinaction.chapter03;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class TestTrans {

    private static Jedis jedis = new Jedis();

    @Test
    public void testWatch() {
        Transaction transaction = jedis.multi();
        transaction.setnx("key1", "value1");
        transaction.setnx("key2", "value2");
        Response<Long> res = transaction.setnx("key2", "value2");
        transaction.discard();
//        System.out.println(res.get());
//        if (res.get() == 0) {
////            System.out.println(transaction.discard());
//        }



    }

}
