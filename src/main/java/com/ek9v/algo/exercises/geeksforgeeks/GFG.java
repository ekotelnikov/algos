package com.ek9v.algo.exercises.geeksforgeeks;

import java.util.Scanner;

/**
 * Created by user on 01.09.2017.
 */
public class GFG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        int[] results = new int[testCases];
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
            results[t - 1] = maxIndex.calc();
        }
        for (int result : results) {
            System.out.println(result);
        }
    }
}
