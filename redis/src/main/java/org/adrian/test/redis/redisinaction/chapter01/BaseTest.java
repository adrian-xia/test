package org.adrian.test.redis.redisinaction.chapter01;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class BaseTest {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("localhost", 6379);
    }

    @Test
    public void testString() {
        //set string "hello world"
        jedis.set("hello", "world");
        //get string
        System.out.println(jedis.get("hello"));
        //del string
        jedis.del("hello");
        //get string
        System.out.println(jedis.get("hello"));
    }

    @Test
    public void testList() {
        System.out.println(jedis.rpush("list-key", "item"));
        System.out.println(jedis.rpush("list-key", "item2"));
        System.out.println(jedis.rpush("list-key", "item"));
//        System.out.println(jedis.rpush("list-key".getBytes(), "item".getBytes()));
        System.out.println(jedis.lrange("list-key", 0, -1));
        System.out.println(jedis.lindex("list-key", 1));
        System.out.println(jedis.lpop("list-key"));
        System.out.println(jedis.lrange("list-key", 0 ,-1));
    }

    @Test
    public void testSet() {
        System.out.println(jedis.sadd("set-key", "item"));
        System.out.println(jedis.sadd("set-key", "item2"));
        System.out.println(jedis.sadd("set-key", "item3"));
        System.out.println(jedis.sadd("set-key", "item"));
        System.out.println(jedis.smembers("set-key"));
        System.out.println(jedis.sismember("set-key", "item4"));
        System.out.println(jedis.sismember("set-key", "item"));
        System.out.println(jedis.srem("set-key", "item2"));
        System.out.println(jedis.sismember("set-key", "item2"));
        System.out.println(jedis.smembers("set-key"));
    }

    @Test
    public void testHash() {

    }

    @Test
    public void testZSet() {

    }

    @Test
    public void testNx() {

    }

    @Test
    public void testKeys() {
        System.out.println(jedis.keys("*"));
    }

}
