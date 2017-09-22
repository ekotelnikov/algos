package com.ek9v.coursera.greedy;

import java.util.Scanner;

public class Change {

    static int getChange(int m) {
        int[] coins = {10, 5, 1};
        int i = 0;
        int c = coins[i];
        int total = 0;
        while (m > 0) {
            if (m >= c) {
                total++;
                m = m - c;
            } else {
                c = coins[++i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

