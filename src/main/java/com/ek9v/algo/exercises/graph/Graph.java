package com.ek9v.algo.exercises.graph;

import com.ek9v.algo.exercises.TreeBST;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by user on 21.01.2017.
 */
public class Graph {

	private Node root;

	private int count = 0;

	private Map<Node, Node> nodeSet = new LinkedHashMap<>();

	private int[] s = new int[] {10, 7, 4};

	public Graph(Node root) {
		this.root = root;
	}

	public Node dst(int s) {
		Node rNode = root;
		Set<Node> visited = new HashSet<>();
		List<Node> result = new ArrayList<>();
		explore(rNode, visited, node -> node.hasValue(s), result);
		Node fNode = result.get(0);
		for (Node r : result) {
			if (r.pre < fNode.pre) {
				fNode = r;
			}
		}
		return fNode;
	}

	private void explore(Node rNode, Set<Node> visited, Predicate<Node> p, List<Node> result) {
		rNode.pre = rNode.pre == 0 ? ++count : rNode.pre;
		visited.add(rNode);
		if (p.test(rNode)) {
			result.add(rNode);
		}
		Set<Node> sNodes = rNode.nodes;
		sNodes.stream()
				.filter(n -> !visited.contains(n))
				.forEach(n -> {
					explore(n, visited, p, result);
				});
		rNode.post = rNode.post == 0 ? ++count : rNode.post;
	}

	public List<Node> build() {
		Node rNode = this.root;
		nodeSet.put(rNode, rNode);
		addPossibleNodes(rNode);
		return nodeSet.values().stream().collect(Collectors.toList());
	}

	private void addPossibleNodes(Node rNode) {
		List<Node> pSets = getPossibleSets(rNode);
		for (Node pNode : pSets) {
			Node eNode = nodeSet.get(pNode);
			rNode.add(eNode == null ? pNode : eNode);
			if (eNode == null) {
				nodeSet.put(pNode, pNode);
				addPossibleNodes(pNode);
			}
		}
	}

	List<Node> getPossibleSets(Node rNode) {
		List<Node> p = new ArrayList<>();

		int[] v = Arrays.copyOf(rNode.v, rNode.v.length);
		for (int i = 0; i < v.length; i++) {
			int r = s[i] - v[i];
			for (int j = 0; j < v.length && r > 0; j++) {
				if (i != j && v[j] > 0) {
					int[] nv = Arrays.copyOf(v, v.length);
					if (v[j] <= r) {
						nv[i] = v[i] + v[j];
						nv[j] = 0;
					} else {
						nv[i] += r;
						nv[j] -= r;
					}
					Node n = new Node(nv[0], nv[1], nv[2]);
					p.add(n);
				}
			}
		}

		return p;
	}

	public static class Node {
		private int[] v = new int[3];

		private Set<Node> nodes = new HashSet<>();

		private int pre;
		private int post;

		Node(int a, int b, int c) {
			v[0] = a; v[1]= b; v[2] = c;
		}

		boolean hasValue(int value) {
			return v[0] == value || v[1] == value || v[2] == value;
		}

		boolean add(Node node) {
			return this.nodes.add(node);
		}

		boolean contains(Node node) {
			return nodes.contains(node);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return Arrays.equals(v, node.v);
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(v);
		}

		@Override
		public String toString() {
			return "Node{" +
					"v=" + Arrays.toString(v) +
					", pre=" + pre +
					", post=" + post +
					'}';
		}
	}
}
