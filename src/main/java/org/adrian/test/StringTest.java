package org.adrian.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author adrian
 * @version Id: SpringTest, v 0.1 2020/2/19 下午5:56 adrian Exp $
 */
public class StringTest {

    @Test
    public void test1() {
        String key1 = "HKTSHA20200220FM858";
        String key2 = "HKTSHA20200220FM858";
//        int i = key1.indexOf("-");
//        System.out.println("i = " + i);
//        System.out.println("sub = " + key1.substring(i + 1));
        Set<String> set = new HashSet<>();
        set.add(key1);
        set.add(key2);
        System.out.println(set.size());// 1
    }


    /**
     * JDK1.8
     * String.intern()方法的作用
     * 1. 单独使用””引号创建的字符串都是常量，编译期就已经确定存储到String Pool中。
     * 2. 使用new String(“”)创建的对象会存储到heap中，是运行期新创建的对象。
     * 3. 使用只包含常量的字符串连接符如”aa”+”bb”创建的也是常量，编译期就能确定已经存储到String Pool中。
     * 4. 使用包含变量的字符串连接如”aa”+s创建的对象是运行期才创建的，存储到heap中。
     * 5. 运行期调用String的intern()方法可以向String Pool中动态添加对象。
     * 注意:   1. JDK1.7+版本中, 直接将堆中的字符串引用赋值给字符串常量池中的hashtable中;
     * 2. JDK1.6版本中, 1)将堆中的字符串复制一份在字符串常量池中, 再讲复制后的引用赋值给常量池的hashtable
     */
    @Test
    public void test2() {
        String c = "world";
        System.out.println(c.intern() == c);//true

        String d = new String("mike");
        System.out.println(d.intern() == d);//false

        String e = new String("jo") + new String("hn");
        System.out.println(e.intern() == e);//true

        String f = new String("ja") + new String("va");
        System.out.println(f.intern() == f);//false, "java"关键字在虚拟机中存在
    }

    @Test
    public void testSplit() {
        System.out.println("1;".split(";").length);
    }
}
