package com.ek9v.coursera.greedy;

import java.util.*;

public class DifferentSummands {
    static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        int s = 1;
        while (n > 2 * s) {
            n = n - s;
            summands.add(s++);
        }
        summands.add(n);

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

