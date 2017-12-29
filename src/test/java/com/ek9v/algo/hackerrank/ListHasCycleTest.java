package com.ek9v.algo.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 15.12.2017.
 */
public class ListHasCycleTest {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Set<Node> s = new HashSet<>();
        while (head != null) {
            if (s.contains(head)) {
                return true;
            }
            s.add(head);
            head = head.next;
        }
        return false;
    }

    @Test
    public void returnFalse_whenHeadIsNull() throws Exception {
        assertThat(hasCycle(null), is(false));
    }

    @Test
    public void returnFalse_whenNextIsNull() throws Exception {
        assertThat(hasCycle(new Node()), is(false));
    }

    @Test
    public void returnFalse_whenListIsLinear() throws Exception {
        Node head = new Node();
        Node node = new Node();
        head.next = node;
        for (int i = 0; i < 100; i++) {
            node.next = new Node();
            node = node.next;
        }
        node.next = null;
        assertThat(hasCycle(head), is(false));
    }

    @Test
    public void returnTrue_whenListOneNodeCycle() throws Exception {
        Node head = new Node();
        head.next = head;
        assertThat(hasCycle(head), is(true));
    }

    @Test
    public void returnTrue_whenListIsCircle() throws Exception {
        Node head = new Node();
        head.next = new Node();
        head.next.next = head;

        assertThat(hasCycle(head), is(true));
    }

    @Test
    public void returnTrue_whenListHasCycle() throws Exception {
        Node head = new Node();
        head.next = new Node();
        head.next.next = new Node();
        head.next.next.next = head.next;

        assertThat(hasCycle(head), is(true));
    }
}
