package com.ek9v.algo.exercises.graph;

import com.ek9v.algo.exercises.graph.CommonGraph.Node;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 28.01.2017.
 */
public class CommonGraphTest {

    @Test
    public void testBuild() {
        Node<Integer> nodeOne = new Node<>(1);
        Node<Integer> node2 = new Node<>(3);
        nodeOne.add(node2);
        Node<Integer> node4 = new Node<>(7);
        node2.add(node4);

        Node<Integer> node3 = new Node<>(5);
        nodeOne.add(node3);
        Node<Integer> node5 = new Node<>(4);
        node3.add(node5);
        Node<Integer> node6 = new Node<>(6);
        node3.add(node6);

        node5.add(node6);
        node6.add(node2);

        CommonGraph<Integer> graph = new CommonGraph(nodeOne);
        Map<Node<Integer>, List<Node<Integer>>> nodes = graph.dfs();

        assertThat(nodes.isEmpty(), is(false));
        assertThat(nodes.values().isEmpty(), is(false));
        for (Node n: nodes.keySet()) {
            assertThat(n.getS(), not(-1));
            assertThat(n.getE(), not(-1));
        }
    }

}