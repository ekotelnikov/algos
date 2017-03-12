package com.ek9v.algo.exercises.graph;

import com.ek9v.algo.exercises.graph.Graph.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by user on 21.01.2017.
 */
public class GraphTest {

    @Test
    public void testGetPossibleSets() {
        Graph g = new Graph(new Node(0, 7, 4));

        List<Node> pNodes = g.getPossibleSets(new Node(0, 7, 4));

        Node first = new Node(7, 0, 4);
        Node second = new Node(4, 7, 0);
        Assert.assertThat(pNodes.get(0), is(first));
        Assert.assertThat(pNodes.get(1), is(second));
    }

    @Test
    public void testGetPossibleSets_740() {
        Graph g = new Graph(new Node(7, 4, 0));

        List<Node> pNodes = g.getPossibleSets(new Node(7, 4, 0));

        Node first = new Node(7, 0, 4);
        Node second = new Node(3, 4, 4);
        Node third = new Node(10, 1, 0);
        Assert.assertThat(pNodes.contains(first), is(true));
        Assert.assertThat(pNodes.contains(second), is(true));
        Assert.assertThat(pNodes.contains(third), is(true));
    }

    @Test
    public void testBuild() throws Exception {
        Graph g = new Graph(new Node(0, 7, 4));
        List<Node> nSet = g.build();

        Assert.assertThat(nSet, not(nullValue()));
    }

    @Test
    public void testDst() throws Exception {
        Graph g = new Graph(new Node(0, 7, 4));
        List<Node> nSet = g.build();
        Node d = g.dst(2);

        Assert.assertThat(d, not(nullValue()));
        Assert.assertThat(d.hasValue(2), is(true));
    }
}