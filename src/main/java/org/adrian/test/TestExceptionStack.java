package org.adrian.test;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xl48886
 * @version Id : TestExceptionStack, v 0.1 2018/01/30 上午11:41 xl48886 Exp $
 */
public class TestExceptionStack {

    public static void main(String[] args) throws Exception {
        String dateStr = "2017-12-3123:22:2";
        String format = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            String stackTrace = getStackTrace(e);
            Thread.sleep(1111);
            System.out.println(stackTrace);
            Thread.sleep(1111);
            throw e;
        }
        System.out.println(date);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    @Test
    public void testString() {
        String str = "1234567";
        int length = 10;
        if (str.length() > length) {
            str = str.substring(0, length);
        }
        System.out.println(str);
    }

}
