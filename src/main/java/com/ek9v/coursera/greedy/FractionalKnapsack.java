package com.ek9v.coursera.greedy;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.math.RoundingMode.HALF_UP;

public class FractionalKnapsack {

    static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        for (int i = 0; i < values.length; i++) {
            if (capacity == 0) {
                return value;
            }
            int max = getMax(values, weights);
            if (weights[max] <= 0) {
                return value;
            }
            int a = min(weights[max], capacity);
            value += a * ((double) values[max] / weights[max]);
            weights[max] = weights[max] - a;
            capacity = capacity - a;
        }

        return BigDecimal.valueOf(value).setScale(4, HALF_UP).doubleValue();
    }

    private static int getMax(int[] values, int[] weights) {
        int w_max = 0;
        for (int i = 1; i < values.length; i++) {
            double valueWeight_i = (double) values[i] / weights[i];
            double valueWeight_max = (double) values[w_max] / weights[w_max];
            if (weights[w_max] <= 0 || (weights[i] > 0 && valueWeight_i > valueWeight_max)) {
                w_max = i;
            }
        }
        return w_max;
    }

    private static int min(int w, int c) {
        return w < c ? w : c;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
