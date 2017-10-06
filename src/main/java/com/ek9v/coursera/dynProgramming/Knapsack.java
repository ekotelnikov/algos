package com.ek9v.coursera.dynProgramming;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[][] values = new int[W+1][w.length+1];

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                values[j][i] = values[j][i-1];
                if (w[i-1] <= j) {
                    int val = values[j-w[i-1]][i-1] + w[i-1];
                    if (val > values[j][i]) {
                        values[j][i] = val;
                    }
                }
            }
        }
        return values[W][w.length];
//        int result = 0;
//        for (int i = 0; i < w.length; i++) {
//          if (result + w[i] <= W) {
//            result += w[i];
//          }
//        }
//        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

