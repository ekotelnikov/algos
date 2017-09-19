package com.ek9v.coursera.introduction;

import java.util.Scanner;

public class Fibonacci {
  static long calc_fib(int n) {

    if (n == 0) return 0;

    int[] fNumbers = new int[n + 1];
    fNumbers[0] = 0;
    fNumbers[1] = 1;
    for (int i = 2; i <= n; i++) {
      fNumbers[i] = fNumbers[i - 1] + fNumbers[i - 2];
    }
    return fNumbers[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
