package org.adrian.test.redis.redisinaction.chapter01;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.*;

/**
 * 简单投票系统
 */
public class TestVote {

    private Jedis jedis;

    private static Integer ONE_WEEK_IN_SECOND = 60 * 60 * 24 * 7;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    @Before
    public void before() {
        jedis = new Jedis("localhost", 6379);
    }


    @Test
    public void testPostArticle() {
        System.out.println(postArticle(jedis, "xugang", "spring_in_action", "spring.io"));
    }

    private String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));
        String voted = "voted:" + articleId;
        conn.sadd(voted, user);
        conn.expire(voted, ONE_WEEK_IN_SECOND);
        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        Map<String, String> articleData = new HashMap<>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("poster", user);
        articleData.put("time", String.valueOf(now));
        articleData.put("votes", "1");
        conn.hmset(article, articleData);
        conn.zadd("score:", now + VOTE_SCORE, article);
        conn.zadd("time:", now, article);
        return articleId;
    }

    @Test
    public void testArticleVote() {
//        articleVote(jedis, "feixiang", "article:1");
        articleVote(jedis, "fanjuan", "article:1");
    }

    private void articleVote(Jedis conn, String user, String article) {
        long cutoff = System.currentTimeMillis() / 1000 - ONE_WEEK_IN_SECOND;
        if (conn.zscore("time:", article) < cutoff) {
            return;
        }
        String articleId = article.split(":")[1];
        if (conn.sadd("voted:" + articleId, user) > 0) {
            conn.zincrby("score:", VOTE_SCORE, article);
            conn.hincrBy(article, "votes", 1);
        }
    }

    @Test
    public void testGetArticles() {
        System.out.println(getArticles(jedis, 1, "score:"));
    }

    private List<Map<String, String>> getArticles(Jedis conn, int page, String order) {
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;
        Set<String> ids = conn.zrevrange(order, start, end);
        List<Map<String, String>> articles = new ArrayList<>();
        for (String id : ids) {
            Map<String, String> articleData = conn.hgetAll(id);
            articleData.put("id", id);
            articles.add(articleData);
        }
        return articles;
    }

    @Test
    public void testAddAndRemoveGroups() {
        List<String> toAdd = new ArrayList<>();
        toAdd.add("facebook");
        toAdd.add("youtube");
        addAndRemoveGroups(jedis, "1", toAdd, new ArrayList<>());
    }

    private void addAndRemoveGroups(Jedis conn, String articleId, List<String> toAdd, List<String> toRemove) {
        String article = "article:" + articleId;
        for (String group : toAdd) {
            conn.sadd("group:" + group, article);
        }
        for (String group : toRemove) {
            conn.srem("group:" + group, article);
        }
    }

    @Test
    public void testGetGroupArticles() {
        System.out.println(getGroupArticles(jedis, "facebook", 1, "score:"));
    }

    /**
     * ZUNIONSTORE destination numkeys key [key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM|MIN|MAX]
     * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
     * WEIGHTS
     * 使用 WEIGHTS 选项，你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication factor)，
     * 每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation function)之前都要先乘以该有序集的因子。
     * 如果没有指定 WEIGHTS 选项，乘法因子默认设置为 1 。
     * AGGREGATE
     * 使用 AGGREGATE 选项，你可以指定并集的结果集的聚合方式。
     * 默认使用的参数 SUM ，可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；使用参数 MIN ，
     * 可以将所有集合中某个成员的最小score值作为结果集中该成员的score值；而参数MAX则是将所有集合中某个成员的最大score值作为结果集中该成员的score值。
     */
    private List<Map<String, String>> getGroupArticles(Jedis conn, String group, int page, String order) {
        String key = order + group;//检查是否有已缓存的排序结果
        if (!conn.exists(key)) {
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MIN);//todo
            conn.zinterstore(key, params, "group:" + group, order);
            conn.expire(key, 60);//缓存60秒
        }
        return getArticles(conn, page, key);
    }



}
