package org.adrian.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author adrian
 * @version Id: SpringTest, v 0.1 2020/2/19 下午5:56 adrian Exp $
 */
public class StringTest {

    public static void main(String[] args) {
        String key1 = "HKTSHA20200220FM858";
        String key2 = "HKTSHA20200220FM858";
//        int i = key1.indexOf("-");
//        System.out.println("i = " + i);
//        System.out.println("sub = " + key1.substring(i + 1));
        Set<String> set = new HashSet<>();
        set.add(key1);
        set.add(key2);
        System.out.println(set.size());
    }
}
