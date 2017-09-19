package com.ek9v.coursera.introduction;

import java.util.*;

public class FibonacciHuge {

    static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    static long getFibonacciHugeFast(long n, int m) {
        if (n <= 1)
            return n;

        int a = getPisanoLength(m);

        long previous = 0;
        long current  = 1;

        long mod = n % a;
        if (mod <= 1) {
            return mod;
        }

        for (long i = 0; i < mod - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }

    static int getPisanoLength(int n) {
        long previous = 0;
        long current  = 1;

        int i = 1;
        do {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % n;
            i++;
        } while (!(previous == 0 && current == 1));

        return i - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

