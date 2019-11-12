package zju.query;

/**
 * 链表反转
 * Created by xialei on 2017/3/16.
 */
public class LinkedReverse {


    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node tmp = head.getNext();
            head.setNext(prev);
            prev = head;
            head = tmp;
        }
        return prev;
    }

    /**
     *      head = a,b,c,d
     *  1.  tmp = b,c,d
     *      head = a
     *      prev = a
     *      head = b,c,d
     *  2.  tmp = c,d
     *      head = b,a
     *      prev = b,a
     *      head = c,d
     *  3.  tmp = d
     *      head = c,b,a
     *      prev = c,b,a
     *      head = d
     *  4.  tmp = null
     *      head = d,c,b,a
     *      prev = d,c,b,a
     *      head = null
     */
}


class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}