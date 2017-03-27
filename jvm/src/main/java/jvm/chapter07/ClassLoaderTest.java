package jvm.chapter07;

import java.io.IOException;
import java.io.InputStream;

/**
 * 比较两个类是否相等, Class对象的equals(), isAssignableFrom(), isInstance(), instanceof关键字
 * 只有在这两个类由同一个类加载器加载的前提下才有意义,
 * 否则, 即使两个类来源同一个Class文件,
 * 被同一个虚拟机加载, 只要加载它们的类加载器不同, 那这两个类必定不相等
 * Created by xialei on 2017/3/25.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("jvm.chapter07.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof jvm.chapter07.ClassLoaderTest);
    }

}
