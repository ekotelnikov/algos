package com.ek9v.algo.exercises;

/**
 * Created by user on 15.01.2017.
 */
public class TreeBST {

	private Node root;

	public TreeBST(int rootValue) {
		root = new Node(rootValue);
	}

	public Node add(int value) {
		return add(value, root);
	}

	private Node add(int value, Node node) {
		if (node == null) {
			return new Node(value);
		} else if (value < node.value) {
			node.left = add(value, node.left);
		} else if (value > node.value){
			node.right = add(value, node.right);
		} else {
			return node;
		}
		return node;
	}

	public static TreeBST valueOf(int[] values) {
		if (values.length == 0) {
			return null;
		}
		int r = 0;
		TreeBST t = new TreeBST(values[r]);
		for (int i = 1; i < values.length; i++) {
			int value = values[i];
			t.add(value);
		}
		return t;
	}

	public int distance(int value) {
		Node node = root;
		int dist = 0;
		while (node != null) {
			if (value < node.value) {
				node = node.left;
				dist++;
			} else if (value > node.value) {
				node = node.right;
				dist++;
			} else {
				return dist;
			}
		}
		return -1;
	}

	public void print() {
		print(root);
	}

	private void print(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.print(" " + root.value);
		}
		System.out.print(":");
		System.out.print(" left");
		print(root.left);
		System.out.print(" right");
		print(root.right);
	}

	public class Node {

		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					'}';
		}
	}
}
