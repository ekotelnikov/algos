package com.ek9v.algo.exercises.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 19.01.2017.
 */
public class JourneyToMoon {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int row = 1;
		Union u = new Union(n);
		while (row <= k) {
			int p = in.nextInt();
			int q = in.nextInt();
			if (!u.connected(p, q)) {
				u.union(p, q);
			}
			row++;
		}

		System.out.println(countPairs(u));
	}

	private static long countPairs(Union u) {
		if (u.getCount() > 1) {
			int[] sz = u.getSz();
			int[] ids = u.getIds();
			List<Integer> countries = new ArrayList<>();
			for (int i = 0; i < sz.length; i++) {
				if (ids[i] == i) {
					countries.add(sz[i]);
				}
			}

			long pairs = 0;
			long s = 0;
			for (int i = countries.size() - 1; i > 0; i--) {
				s += countries.get(i);
				pairs += countries.get(i-1) * s;
			}
			return pairs;
		}
		return 0;
	}

	public static long countPairs(int[] p, int n) {
		if (n == 0) {
			return 0;
		}

		Union u = new Union(n);
		for (int i = 0; i < p.length - 1; i += 2) {
			int p_i = p[i];
			int p_q = p[i + 1];
			if (!u.connected(p_i, p_q)) {
				u.union(p_i, p_q);
			}
		}
		return countPairs(u);
	}

}
