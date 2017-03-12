package com.ek9v.algo.exercises.hackerrank;

import java.util.Arrays;

/**
 * Created by user on 18.01.2017.
 */
public class SockMerchant {

	public static int calc(int[] s) {
		if (s.length == 0) {
			return 0;
		}

		Arrays.sort(s);

		int pairs = 0;
		int p = 0;
		int cS = s[0];
		for (int i = 0; i < s.length; i++) {
			int c = s[i];
			if (c == cS) {
				p++;
			}
			if (c != cS || i == s.length - 1) {
				pairs += p / 2;
				p = 1;
				cS = c;
			}
		}
		return pairs;
	}
}
