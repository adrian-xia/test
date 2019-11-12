package org.adrian.test;

import java.math.BigDecimal;

/**
 * @author xl48886
 * @version Id : TestConvertor, v 0.1 2018/03/15 上午10:45 xl48886 Exp $
 */
public class TestConverter {

    public static void main(String[] args) {
        String value = "100.1";
        BigDecimal i = new BigDecimal(value);
        System.out.println(i.setScale(0, BigDecimal.ROUND_UP).intValue());
    }

}
