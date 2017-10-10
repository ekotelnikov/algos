package com.ek9v.coursera.basicDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHeightCalc {
    static class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static class TreeHeight {
		int n;
		int parent[];
		int root;
		private Node[] nodes;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		void readAsNodes() {
			nodes = new Node[parent.length];
			for (int i = 0; i < parent.length; i++) {
				nodes[i] = new Node(i, parent[i]);
			}

			for (int childIndex = 0; childIndex < nodes.length; childIndex++) {
				int parentIndex = nodes[childIndex].parentIndex;
				if (parentIndex == -1) {
					root = childIndex;
				} else {
					nodes[parentIndex].addChild(nodes[childIndex]);
				}
			}
		}

		int computeHeightBrutForce() {
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
		}

		int computeHeightFast() {
			if (nodes.length == 1) {
				return 1;
			}

			Queue<Node> currentLevel = new LinkedList<>();
			Queue<Node> nextLevel = new LinkedList<>();
			currentLevel.add(nodes[root]);
			int levelCount = 0;
			while (!currentLevel.isEmpty()) {
				Node node = currentLevel.remove();
				if (node.hasChilds()) {
					nextLevel.addAll(node.getChilds());
				}
				if (currentLevel.isEmpty()) {
					currentLevel = nextLevel;
					nextLevel = new LinkedList<>();
					levelCount++;
				}
			}

			return levelCount;
		}
	}

	static class Node {

		final int index;
		final int parentIndex;

		List<Node> childs = new ArrayList<>();

		public Node(int index, int parentIndex) {
			this.index = index;
			this.parentIndex = parentIndex;
		}

		void addChild(Node child) {
			childs.add(child);
		}

		List<Node> getChilds() {
			return childs;
		}

		public boolean hasChilds() {
			return !childs.isEmpty();
		}

		@Override
		public String toString() {
			return "Node{" +
					"index=" + index +
					", parentIndex=" + parentIndex +
					'}';
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new TreeHeightCalc().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public static void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		tree.readAsNodes();
		System.out.println(tree.computeHeightFast());
	}
}
