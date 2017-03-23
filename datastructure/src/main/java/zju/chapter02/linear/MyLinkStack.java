package zju.chapter02.linear;

/**
 * Created by adrian on 2017/3/23.
 */
public class MyLinkStack<T> {

    private Node<T> node;

    public MyLinkStack() {
        node = new Node<>();
    }

    public boolean isEmpty() {
        return node.next == null;
    }

    public void push(T e) {
        Node<T> next = new Node<>();
        next.e = e;
        next.next = node.next;
        node.next = next;
    }

    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> popElement = node.next;
        node.next = popElement.next;
        return popElement.e;
    }

    private class Node<T> {
        private T e;
        private Node<T> next;
    }

    public static void main(String[] args) {
        MyLinkStack<String> myStack = new MyLinkStack<>();
        System.out.println(myStack.isEmpty());
        myStack.push("One");
        myStack.push("two");

        String ele = myStack.pop();
        System.out.println(ele);
        myStack.pop();
        myStack.pop();
    }

}
