package chapter03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * Created by xialei on 2017/2/23.
 */
public class MyLinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        public Node(T t, Node<T> p, Node<T> n) {
            data = t;
            prev = p;
            next = n;
        }

        public T data;
        public Node<T> prev;
        public Node<T> next;
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    public void add(int idx, T t) {
        addBefore(getNode(idx), t);
    }

    public T get(int idx) {
        return null;
    }

    public T set(int idx, T newVal) {
        return null;
    }

    public T remove(int idx) {
        return null;
    }

    private void addBefore(Node<T> p, T t) {
        Node<T> newNode = new Node<>(t, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx) {
        Node<T> p;
        if (idx < 0 || (idx > size())) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = beginMarker.next;
        private int expectdeModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectdeModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectdeModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectdeModCount++;
        }
    }

    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("100");
        linkedList.add("200");
        linkedList.add("300");
        linkedList.add("400");
        linkedList.add("500");
        for (String s : linkedList) {
            System.out.println(s);
        }
        String value = linkedList.get(5);
        System.out.println(value);

        LinkedList<String> l = new LinkedList<>();
        l.add("100");
        l.add("200");
        l.add("300");
        l.add("400");
        l.add("500");
//        System.out.println(l.get(5)); //throw new ArrayIndexOutOfBoundsException

        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            if ("400".equals(it.next())) {
                it.remove();
            }
        }
        System.out.println("ok");
    }
}
