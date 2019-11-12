package jvm.chapter03;

/**
 * 使用finalize方法进行重新引用，防止gc销毁
 * 任何一个对象的finalize()方法只会被系统调用一次
 * Created by xialei on 2017/3/17.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive!");
    }

    /**
     * 该方法在应用的生命周期只会执行一次
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        //此处的无限循环虚拟机会在执行一段时间后结束运行。
//        while (true)
//            System.out.println("haha");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        //finalize(0 方法优先级别很低，所以暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead!");
        }

        SAVE_HOOK = null;
        System.gc();
        //finalize(0 方法优先级别很低，所以暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead!");
        }
    }
}
