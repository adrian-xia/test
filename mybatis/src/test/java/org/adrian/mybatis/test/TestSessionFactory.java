package org.adrian.mybatis.test;

import org.adrian.mybatistest.dao.UserMapper;
import org.adrian.mybatistest.domain.UserDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * Created by xialei on 2017/3/3.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring/spring-all.xml")
public class TestSessionFactory {

    private SqlSessionFactory sessionFactory;

    {
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/sqlsessionfactory.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectOne() {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserDO userDO = userMapper.selectOne(1L);
            System.out.println(userDO);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void sessionSelectOne() {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            UserDO userDO = sqlSession.selectOne("org.adrian.mybatistest.dao.UserMapper.selectOne", 1L);
            System.out.println(userDO);
        } finally {
            sqlSession.close();
        }
    }

}
