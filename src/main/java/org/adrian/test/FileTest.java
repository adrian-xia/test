package org.adrian.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author xl48886
 * @version Id : FileTest, v 0.1 2019/08/29 19:41 xl48886 Exp $
 */
public class FileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\adria\\Desktop\\20190902235220.xlsx");
        byte[] by;
        InputStream is  = new FileInputStream(file);
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        byte[] bb = new byte[2048];
        int ch;
        ch = is.read(bb);
        while (ch != -1) {
            bytestream.write(bb, 0, ch);
            ch = is.read(bb);
        }
        by = bytestream.toByteArray();
        System.out.println(Arrays.toString(by));
    }

}
