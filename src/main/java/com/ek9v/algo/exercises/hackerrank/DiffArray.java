package com.ek9v.algo.exercises.hackerrank;

/**
 * Solution for <a href='https://www.hackerrank.com/challenges/crush/problem'>
 *     PracticeData StructuresArraysArray Manipulation
 *     </a>
 */
public class DiffArray {

    private long[] diff;

    public DiffArray(int n) {
        diff = new long[n];
    }

    public void doOp(int a, int b, int k) {
        diff[a - 1] += k;
        if (b < diff.length) diff[b] -= k;
    }

    public long getMax() {
        long tmp = 0;
        long max = 0;
        for (int i = 0; i < diff.length; i++) {
            tmp += diff[i];
            if (tmp > max) max = tmp;
        }
        return max;
    }
}
