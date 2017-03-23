package zju.chapter02.linear;

/**
 * Created by adrian on 2017/3/23.
 */
public class MyLinkQuene<T> {

    private Node front;
    private Node rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void add(T e) {
        Node node = new Node();
        node.e = e;
        node.next = null;
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public T delete() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T result = front.e;
        if (front.next == null) {
            clear();
        } else {
            front = front.next;
        }
        return result;
    }

    public void clear() {
        this.front = null;
        this.rear = null;
    }

    private class Node {
        private T e;
        private Node next;
    }

    public static void main(String[] args) {
        MyLinkQuene<String> myQuene = new MyLinkQuene<>();
        System.out.println(myQuene.isEmpty());
        myQuene.add("One");
        myQuene.add("two");
        System.out.println(myQuene.delete());
        System.out.println(myQuene.delete());
        System.out.println(myQuene.isEmpty());
    }

}
