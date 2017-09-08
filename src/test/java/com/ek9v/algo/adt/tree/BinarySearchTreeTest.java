package com.ek9v.algo.adt.tree;

import com.ek9v.algo.adt.tree.BinarySearchTree;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Created by user on 02.09.2017.
 */
public class BinarySearchTreeTest {

    @Test
    public void createTree_returnTreeWithNullRoot() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        assertThat(bst.getRoot(), is(nullValue()));
    }

    @Test
    public void addNode_returnTreeWitnNotNullRoot() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(1);
        assertThat(bst.getRoot(), not(nullValue()));
    }

    @Test
    public void treeToList() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(1);
        bst.add(0);
        bst.add(2);
        bst.add(5);
        bst.add(4);
        bst.add(6);
        List<Integer> list = bst.treeToList();
        assertThat(list, contains(0, 1, 2, 3, 4, 5, 6));
    }

    @Test
    public void treeToMapOfNodes() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(3);
        bst.add(1);
        bst.add(2);
        bst.add(0);
        bst.add(5);

        Map<Integer, List<Integer>> nodes = bst.getNodes();

        assertThat(nodes.keySet(), contains(3, 1, 0, 2, 5));
        assertThat(nodes.get(1), contains(0, 2));
        assertThat(nodes.get(0), everyItem(is(nullValue())));
        assertThat(nodes.get(2), everyItem(is(nullValue())));
        assertThat(nodes.get(5), everyItem(is(nullValue())));
    }
}