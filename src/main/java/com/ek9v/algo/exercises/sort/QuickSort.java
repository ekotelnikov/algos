package com.ek9v.algo.exercises.sort;

import java.util.Scanner;

/**
 * Created by user on 02.04.2017.
 */
public class QuickSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = in.nextInt();
        }
        int[] left = new int[n]; left[0] = Integer.MIN_VALUE;
        int[] eq = new int[n + 1];
        int[] right = new int[n]; right[0] = Integer.MIN_VALUE;
        eq[0] = ar[0]; eq[1] = Integer.MIN_VALUE;
        int l = 0; int r = 0; int e = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < eq[0]) {
                left[l++] = ar[i];
                left[l] = Integer.MIN_VALUE;
            } else if (ar[i] > eq[0]) {
                right[r++] = ar[i];
                right[r] = Integer.MIN_VALUE;
            } else {
                eq[e++] = ar[i];
                eq[e] = Integer.MIN_VALUE;
            }
        }
        print(left);
        print(eq);
        print(right);
    }

    private static void print(int[] ar) {
        int i = 0;
        while (ar[i] != Integer.MIN_VALUE || i >= ar.length) {
            System.out.print(ar[i] + " ");
            i++;
        }
    }
}
