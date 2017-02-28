package chapter04;

import java.nio.BufferUnderflowException;

/**
 * 二叉树节点类
 */

public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {

        public BinaryNode(T e) {
            this(e, null, null);
        }

        public BinaryNode(T e, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = e;
            this.left = left;
            this.right = right;
        }

        T element;                    // the data in the node
        BinaryNode<T> left;     // left child
        BinaryNode<T> right;    // right child
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {

    }

    private boolean contains(T t, BinaryNode<T> n) {
        if (n == null) {
            return false;
        }
        int compareResult = t.compareTo(n.element);
        if (compareResult < 0) {
            return contains(t, n.left);
        } else if (compareResult > 0) {
            return contains(t, n.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> n) {
        if (n == null) {
            return null;
        } else if (n.left == null) {
            return n;
        }
        return findMin(n.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> n) {
        if (n != null) {
            while (n.right != null) {
                n = n.right;
            }
        }
        return n;
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> n) {
        if (n == null) {
            return new BinaryNode<T>(t, null, null);
        }
        int compareResult = t.compareTo(n.element);
        if (compareResult < 0) {
            n.left = insert(t, n.left);
        } else if(compareResult > 0) {
            n.right = insert(t, n.right);
        } else {
            //重复数据，do nothing
        }
        return n;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> n) {
        if (n == null) {
            return null;
        }
        int compareResult = t.compareTo(n.element);
        if (compareResult < 0) {
            n.left = remove(t, n.left);
        } else if(compareResult > 0) {
            n.right = remove(t, n.right);
        } else if(n.left != null && n.right != null) {
            n.element = findMin(n.right).element;
            n.right = remove(n.element, n.right);
        } else {
            n = (n.left != null) ? n.left : n.right;
        }
        return n;
    }

    private void printTree(BinaryNode<T> n) {

    }

}


