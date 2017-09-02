package com.ek9v.algo.exercises.geeksforgeeks;

/**
 Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 Example :
 A : [3 5 4 2]
 Output : 2
 for the pair (3, 4)
 */
public class MaximumIndexDiff {
    private final int[] arr;

    public MaximumIndexDiff(int[] arr) {
        this.arr = arr;
    }

    public int calc() {
        return calcN();
//        return calcNSqrt();
    }

    private int calcNSqrt() {
        int n = arr.length;
        if (n == 1) return 0;
        int maxDiff = -1;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] >= arr[i] && j - i > maxDiff) {
                    maxDiff = j - i;
                }
            }
        }
        return maxDiff;
    }

    private int calcN() {
        int n = arr.length;
        if (n == 1) return 0;

        int[] minL = new int[n];
        minL[0] = arr[0];
        for (int i = 1; i < n; i++) {
            minL[i] = min(arr[i], minL[i-1]);
        }

        int[] maxR = new int[n];
        maxR[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            maxR[i] = max(arr[i], maxR[i+1]);
        }

        int i = 0, j = 0;
        int maxDiff = -1;
        while (i < n && j < n) {
            if (maxR[j] > minL[i]) {
                maxDiff = max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    private int min(int x, int y) {
        return x < y ? x : y;
    }

    private int max(int x, int y) {
        return x > y ? x : y;
    }
}
