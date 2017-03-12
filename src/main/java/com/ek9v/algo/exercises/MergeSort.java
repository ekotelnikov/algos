package com.ek9v.algo.exercises;

import java.util.Arrays;

/**
 * Created by user on 14.01.2017.
 */
public class MergeSort {


	public static int[] sort(int[] a, int lo, int hi) {
		System.out.println(String.format("sort %s lo=%s(%s), hi=%s(%s)", Arrays.toString(a), lo, a[lo], hi, a[hi]));
		if (lo >= hi) {
			return a;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		return merge(a, lo, mid, hi);
	}

	private static int[] merge(int[] f, int lo, int mid, int hi) {
		System.out.println(String.format("merge %s lo=%s mid=%s hi=%s",
				Arrays.toString(f), lo, mid, hi));
		int[] aux = new int[f.length];
		for (int k = lo; k <= hi; k++) {
			aux[k] = f[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				f[k] = aux[j++];
			} else if (j > hi) {
				f[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				f[k] = aux[j++];
			} else {
				f[k] = aux[i++];
			}
		}
		System.out.println(Arrays.toString(f));
		return f;
	}

	private static int[] concat(int i, int[] merge) {
		System.out.println(String.format("concat %s and %s", i, Arrays.toString(merge)));
		int[] aux = new int[merge.length + 1];
		aux[0] = i;
		for (int j = 1; j < aux.length; j++) {
			aux[j] = merge[j - 1];
		}
		System.out.println(Arrays.toString(aux));
		return aux;
	}
}
