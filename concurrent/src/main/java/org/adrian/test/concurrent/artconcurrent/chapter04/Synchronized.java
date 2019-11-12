package org.adrian.test.concurrent.artconcurrent.chapter04;

public class Synchronized {

    /*
public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: ldc           #2                  // class org/adrian/test/concurrent/artconcurrent/chapter04/Synchronized
         2: dup
         3: astore_1
         4: monitorenter
         5: aload_1
         6: monitorexit
         7: goto          15
        10: astore_2
        11: aload_1
        12: monitorexit
        13: aload_2
        14: athrow
        15: invokestatic  #3                  // Method m:()V
        18: return
      Exception table:
         from    to  target type
             5     7    10   any
            10    13    10   any
      LineNumberTable:
        line 6: 0
        line 8: 5
        line 10: 15
        line 11: 18

    */
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
            //同步代码块，则在javap字节码反编译，则开始部分monitorenter，结束部分monitorexit
        }

        m();
    }

    /*
    public static synchronized void m();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    Code:
      stack=0, locals=0, args_size=0
         0: return
      LineNumberTable:
        line 15: 0

     */
    public static synchronized void m() {
        //同步方法 使用javap字节码反编译，被 ACC_SYNCHRONIZED 指令修饰
    }

}
