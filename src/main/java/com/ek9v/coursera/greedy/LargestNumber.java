package com.ek9v.coursera.greedy;

import java.util.*;

public class LargestNumber {
    static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        for (int i = 0; i < a.length; i++) {
            int maxDigit = 0;
            int jMax = 0;
            for (int j = 0; j < a.length; j++) {
                if (largestOrEqual(a[j], String.valueOf(maxDigit))) {
                    maxDigit = Integer.valueOf(a[j]);
                    jMax = j;
                }
            }
            a[jMax] = "";
            result += maxDigit;
        }
        return result;
    }

    private static boolean largestOrEqual(String num, String maxDigit) {
        return !num.isEmpty() && largestOrEqualByDigits(num, maxDigit);
    }

    private static boolean largestOrEqualByDigits(String num, String maxDigit) {
        return Integer.valueOf(num + maxDigit) > Integer.valueOf(maxDigit + num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

