package com.ek9v.algo.exercises.graph;

import java.util.*;

/**
 * Created by user on 28.01.2017.
 */
public class CommonGraph<T extends Comparable> {

    private final Node<T> root;

    private int count = 0;

    private Map<Node<T>, List<Node<T>>> nodeList = new LinkedHashMap<>();

    public CommonGraph(Node<T> node) {
        this.root = node;
    }

    public Map<Node<T>, List<Node<T>>> dfsCopy() {
        Set<Node<T>> visited = new HashSet<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
        Node<T> node = root;
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.peekFirst();
            visited.add(node);
            if (node.getS() == -1) {
                node.setS(++count);
            }
            for (Node<T> n : node.getNodes()) {
                if (!visited.contains(n)) {
                    stack.push(n);
                }
            }
            if (node.equals(stack.peekFirst())) {
                node = stack.pop();
                if (node.getE() == -1) {
                    node.setE(++count);
                    nodeList.put(node, node.getNodes());
                }
            }
        }

        return nodeList;
    }

    public Map<Node<T>, List<Node<T>>> dfs() {
        Set<Node<T>> visited = new HashSet<>();
        Deque<Node<T>> stack = new ArrayDeque<>();
        Node<T> node = root;
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.peekFirst();
            if (!visited.contains(node)) {
                node.setS(++count);
                visited.add(node);
                for (Node<T> n : node.getNodes()) {
                    if (!visited.contains(n)) {
                        stack.push(n);
                    }
                }
            } else {
                node = stack.pop();
                if (node.getE() == -1) {
                    node.setE(++count);
                    nodeList.put(node, node.getNodes());
                }
            }
        }

        return nodeList;
    }

    static class Node<T> {
        private T value;
        private List<Node<T>> nodes = new ArrayList<>();
        private int s = -1;
        private int e = -1;

        public List<Node<T>> getNodes() {
            return nodes;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }

        public Node(T value) {
            this.value = value;
        }

        public void add(Node<T> node) {
            this.nodes.add(node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", s=" + s +
                    ", e=" + e +
                    ", nodes=" + nodes +
                    '}';
        }
    }
}
