package com.ek9v.algo.exercises.hackerrank;

/**
 * Created by user on 21.01.2017.
 */
public class InsertSortOne {

	public static void insertIntoSorted(int[] ar) {
		int r = ar.length - 1;
		int v = ar[r];
		for (int i = ar.length - 1; i >= 0; i--) {
			ar[i] = v;
			if (i >= 1 && ar[i-1] >= v) {
				ar[i] = ar[i-1];
			} else {
				print(ar);
				break;
			}
			print(ar);
		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
