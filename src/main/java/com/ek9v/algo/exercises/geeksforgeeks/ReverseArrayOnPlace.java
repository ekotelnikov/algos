package com.ek9v.algo.exercises.geeksforgeeks;

/**
 * Reverse array without using additional memory.
 */
public class ReverseArrayOnPlace {
    private final int[] arr;

    public ReverseArrayOnPlace(int[] arr) {
        this.arr = arr;
    }

    public int[] reverse() {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            arr[i] = arr[n-1-i] - arr[i];
            arr[n-1-i] = arr[n-1-i] - arr[i];
            arr[i] = arr[n-1-i] + arr[i];
        }
        return arr;
    }
}
