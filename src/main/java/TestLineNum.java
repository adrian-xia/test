import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by xialei on 2017/7/7.
 */
public class TestLineNum {
    static long classcount = 0; // 类数
    static long normalLines = 0; // 空行
    static long commentLines = 0; // 注释行
    static long wirteLines = 0; // 代码行

    public static void main(String[] args) throws Exception {
        File f = new File("/Users/xialei/Developer/git-resources/houbank/xloan_mobile"); // 目录
        TestLineNum.treeFile(f);
        System.out.println("路径：" + f.getPath());
        System.out.println("类数：" + classcount);
        System.out.println("空行：" + normalLines);
        System.out.println("注释：" + commentLines);
        System.out.println("代码：" + wirteLines);
        System.out.println("平均:" + wirteLines / classcount);
    }

    /**
     * 查找出一个目录下所有的.java文件
     *
     * @throws Exception
     */

    public static void treeFile(File f) throws Exception {
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            File file = childs[i];
            if (!file.isDirectory()) {
                if (file.getName().endsWith(".java")) {
                    classcount++;
                    BufferedReader br = null;
                    boolean comment = false;
                    br = new BufferedReader(new FileReader(file));
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        line = line.trim();
                        if (line.matches("^[//s&&[^//n]]*$")) {
                            wirteLines++;
                        } else if (line.startsWith("/*")
                                && !line.endsWith("*/")) {
                            commentLines++;
                            comment = true;
                        } else if (true == comment) {
                            commentLines++;
                            if (line.endsWith("*/")) {
                                comment = false;
                            }
                        } else if (line.startsWith("//")) {
                            commentLines++;
                        } else {
                            normalLines++;
                        }
                    }
                    if (br != null) {
                        br.close();
                        br = null;
                    }
                }
            } else {
                treeFile(childs[i]);
            }
        }
    }
}
