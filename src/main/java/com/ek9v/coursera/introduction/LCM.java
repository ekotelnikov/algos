package com.ek9v.coursera.introduction;

import java.util.*;

public class LCM {

  private static int gcd(int a, int b) {
    if (b == 0) return a;

    return gcd(b, a % b);
  }

  static long lcm_fast(int a, int b) {
    return ((long) a * (long) b) / gcd(a, b);
  }

  static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();


    System.out.println(lcm_fast(a, b));
  }
}
