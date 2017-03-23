package zju.chapter02.linear;

/**
 * Created by adrian on 2017/3/23.
 */
public class MyArrayStack<T> {

    private Object[] arr;

    private int top;

    private int maxSize;

    public MyArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
        this.arr = new Object[maxSize];
    }

    public boolean isFull() {
        return top == maxSize;
    }

    public void push(T e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        top++;
        arr[top - 1] = e;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T result = (T)arr[top - 1];
        arr[top - 1] = null;
        top--;
        return result;
    }

    public static void main(String[] args) {
        MyArrayStack<String> myStack = new MyArrayStack<>(10);
        System.out.println("myStack.isEmpty() = " + myStack.isEmpty());
        myStack.push("one");
        myStack.push("two");
        myStack.push("three");
        myStack.push("four");
        myStack.push("five");
        myStack.push("six");
        myStack.push("seven");
        myStack.push("eight");
        myStack.push("nine");
        myStack.push("ten");
        System.out.println("myStack.isFull() = " + myStack.isFull());
        String popElement = myStack.pop();
        System.out.println("myStack.isFull() = " + myStack.isFull() + ", popElement = " + popElement);
    }
}
