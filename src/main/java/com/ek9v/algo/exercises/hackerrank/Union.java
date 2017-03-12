package com.ek9v.algo.exercises.hackerrank;

/**
 * Created by user on 19.01.2017.
 */
public class Union {

	private final int[] id;
	private final int[] sz;
	private int count;

	public Union(int N) {
		id = new int[N];
		sz = new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int find(int n) {
		while (id[n] != n) {
			n = id[n];
		}
		return n;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}

		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
		count--;
	}

	public int[] getSz() {
		return sz;
	}

	public int[] getIds() {
		return id;
	}

	public int getCount() {
		return count;
	}
}
