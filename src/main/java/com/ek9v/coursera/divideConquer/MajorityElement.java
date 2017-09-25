package com.ek9v.coursera.divideConquer;

import java.util.*;
import java.io.*;

public class MajorityElement {

    static int getMajorityElement(int[] a) {
        return getMajorityElementInOnePass(a);
//        return getMajorityElement(a, 0, a.length);
    }

    static int getMajorityElementInOnePass(int[] a) {
        int count = 0;
        int candidate = -1;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                candidate = a[i];
                count++;
            } else if (a[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        if (count > 0) {
            return candidate;
        }
        return -1;
    }

    static int getMajorityElement(int[] a, int left, int right) {
        if (right - left == 1) {
            return a[left];
        }
        int mid = left + (right - left) / 2;
        int ml = getMajorityElement(a, left, mid);
        int mr = getMajorityElement(a, mid, right);

        if (ml == mr) {
            return ml;
        }
        ml = checkMajority(a, left, right, ml);
        if (ml == -1) {
            return checkMajority(a, left, right, mr);
        } else {
            return ml;
        }
    }

    private static int checkMajority(int[] a, int left, int right, int element) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == element) {
                count++;
            }
        }
        if (count > (right - left) / 2) {
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

