package com.ek9v.algo.exercises.hackerrank;

/**
 * Created by user on 18.01.2017.
 */
public class MarsExploration {

	public static int explore(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int w = s.length() / 3;
		StringBuilder eb = new StringBuilder(s.length());
		for (int i = 1; i <= w; i++) {
			eb.append("SOS");
		}
		char[] e = eb.toString().toCharArray();
		char[] m = s.toCharArray();
		int n = 0;
		for (int i = 0; i < e.length; i++) {
			if (m[i] != e[i]) {
				n++;
			}
		}
		return n;
	}
}
