package zju.chapter02.linear;

import java.util.ArrayList;

/**
 * Created by adrian on 2017/3/23.
 */
public class MyStack<T> {

    private ArrayList<T> list;
    private int maxSize;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.list = new ArrayList<>(maxSize);
    }

    public boolean isFull() {
        return list.size() == maxSize;
    }

    public void push(T e) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list.add(e);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T pop() {
        T result = list.get(list.size() - 1);
        list.remove(result);
        return result;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>(10);
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
