package com.ek9v.coursera.introduction;

import java.util.*;

public class FibonacciSumLastDigit {

    static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    static int getFibonacciSumFast(long n) {
        int r = (int) getFibonacciHugeFast(n + 2, 10);
        if (r == 0) {
            return 9;
        }
        return r - 1;
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
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

