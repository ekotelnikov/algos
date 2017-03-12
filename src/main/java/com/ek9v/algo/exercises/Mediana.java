package com.ek9v.algo.exercises;

/**
 * Created by user on 15.01.2017.
 */
public class Mediana {

	public static int[] split(int[] a) {
		int s = a[2];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > s) {
				int t = a[i];
				a[i] = a[s];
				a[s] = t;
			}
		}

		return a;
	}
}
