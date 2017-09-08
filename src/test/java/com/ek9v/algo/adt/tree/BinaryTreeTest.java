package com.ek9v.algo.adt.tree;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * Created by user on 05.09.2017.
 */
public class BinaryTreeTest {

    @Test
    public void getDistance() throws Exception {
        Node<Integer> root = new Node<>(0);
        root.left = new Node<>(4);
        root.left.left = new Node<>(2);
        root.left.right = new Node<>(6);
        root.right = new Node<>(3);
        root.right.left = new Node<>(7);
        root.right.right = new Node<>(9);

        BinaryTree binaryTree = new BinaryTree<>(root);
        assertThat(binaryTree.getNodesOnDistance(2), containsInAnyOrder(2, 6, 7, 9));
    }
}