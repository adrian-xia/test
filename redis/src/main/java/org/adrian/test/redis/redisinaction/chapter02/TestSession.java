package org.adrian.test.redis.redisinaction.chapter02;

import org.junit.Before;
import redis.clients.jedis.Jedis;

public class TestSession {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("localhost", 6379);
    }

    public String checkToken(Jedis conn, String token) {
        return conn.hget("login:", token);
    }

    public void updateToken(Jedis conn, String token, String user, String item) {
        long timestamp = System.currentTimeMillis() / 1000;
        conn.hset("login:", token, user);
        conn.zadd("recent:", timestamp, token);
        if (item != null) {
            conn.zadd("viewed:" + token, timestamp, item);
            conn.zremrangeByRank("viewed:" + token, 0, -26);
            conn.zincrby("viewed:", -1, item);
        }

    }


}
