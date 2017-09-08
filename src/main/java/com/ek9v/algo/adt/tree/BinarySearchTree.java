package com.ek9v.algo.adt.tree;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Not recursive binary search tree implementation.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private Map<T, List<T>> nodes = new LinkedHashMap<T, List<T>>();

    public Node<T> getRoot() {
        return root;
    }

    public void add(T value) {
        if (this.root == null) {
            this.root = new Node<T>(value);
            return;
        }

        Node<T> prev = root;
        Node<T> n = getNextNode(root, value);
        while (n != null) {
            prev = n;
            n = getNextNode(n, value);
        }

        Node<T> newNode = new Node<T>(value);
        if (prev.value.compareTo(value) > 0) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
    }

    private Node<T> getNextNode(Node<T> node, T value) {
        return node.value.compareTo(value) > 0 ? node.left : node.right;
    }

    public Map<T, List<T>> getNodes() {
        preorderTraverse(root);
        return nodes;
    }

    private List<T> preorderTraverse(Node<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> list = new LinkedList<T>();
        list.add(node.value);
        nodes.put(node.value, Lists.newArrayList(node.getLeftValue(), node.getRightValue()));
        list.addAll(preorderTraverse(node.left));
        list.addAll(preorderTraverse(node.right));
        return list;
    }


    public List<T> treeToList() {
        return inorderTraverse(root);
    }

    private List<T> inorderTraverse(Node<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        LinkedList<T> list = new LinkedList<T>();
        list.addAll(inorderTraverse(node.left));
        list.add(node.value);
        list.addAll(inorderTraverse(node.right));
        return list;
    }
}
