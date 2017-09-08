package com.ek9v.algo.adt.tree;

/**
 * Node for BST.
 */
public class Node<T> {

    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public T getLeftValue() {
        return left == null ? null : left.value;
    }

    public T getRightValue() {
        return right == null ? null : right.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
