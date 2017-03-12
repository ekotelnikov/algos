package com.ek9v.algo;

/**
 * Created by user on 17.12.2016.
 */
public final class Algo {

	private int steps = 0;

	public Algo() {}

	public int gtc(int p, int q) {
		steps++;
		if (q == 0) return p;

		int r = p % q;
		return gtc(q, r);
	}

	public int getSteps() {
		return steps;
	}
}
