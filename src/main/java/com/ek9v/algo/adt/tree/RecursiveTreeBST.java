package com.ek9v.algo.adt.tree;

/**
 * Created by user on 15.01.2017.
 */
public class RecursiveTreeBST {

	private Node<Integer> root;

	public RecursiveTreeBST(int rootValue) {
		root = new Node<>(rootValue);
	}

	public Node add(int value) {
		return add(value, root);
	}

	private Node<Integer> add(int value, Node<Integer> node) {
		if (node == null) {
			return new Node<>(value);
		} else if (value < node.value) {
			node.left = add(value, node.left);
		} else if (value > node.value){
			node.right = add(value, node.right);
		} else {
			return node;
		}
		return node;
	}

	public static RecursiveTreeBST valueOf(int[] values) {
		if (values.length == 0) {
			return null;
		}
		int r = 0;
		RecursiveTreeBST t = new RecursiveTreeBST(values[r]);
		for (int i = 1; i < values.length; i++) {
			int value = values[i];
			t.add(value);
		}
		return t;
	}

	public int distance(Integer value) {
		Node<Integer> node = root;
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

}
