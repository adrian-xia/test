package jvm.chapter08;

/**
 * 动态分派的重要体现: 重写(多态)
 * 动态分派发生在运行期间
 * Created by xialei on 2017/3/27.
 */
public class DynamicDispatch {

    private static abstract class Human {
        protected abstract void sayHello();
    }

    private static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    private static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
