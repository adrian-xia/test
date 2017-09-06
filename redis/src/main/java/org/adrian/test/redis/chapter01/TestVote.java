package org.adrian.test.redis.chapter01;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

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
        System.out.println(postArticle(jedis, "xialei", "redis_in_action", "redis.io"));
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



}
