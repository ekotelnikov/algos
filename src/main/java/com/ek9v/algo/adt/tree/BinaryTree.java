package com.ek9v.algo.adt.tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary tree.
 */
public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public List<T> getNodesOnDistance(int distance) {
        return getNodesOnDistance(root, distance);
    }

    private List<T> getNodesOnDistance(Node<T> node, int distance) {
        if (node == null) {
            return Collections.emptyList();
        }
        if (distance == 0) {
            System.out.println(node.value);
            return Lists.newArrayList(node.value);
        }

        List<T> nodes = new ArrayList<T>();
        nodes.addAll(getNodesOnDistance(node.left, distance - 1));
        nodes.addAll(getNodesOnDistance(node.right, distance - 1));

        return nodes;
    }
}
