package com.ek9v.coursera.divideConquer;

import java.util.*;

public class Inversions {

    static long mergeSort(long[] a, long[] b, int left, int right) {
        long invCount = 0;
        if (right <= left) {
            b[left] = a[left];
            return invCount;
        }
        int mid = (right + left) / 2;
        invCount = mergeSort(a, b, left, mid);
        invCount += mergeSort(a, b, mid + 1, right);
        invCount += mergeAndCount(a, b, left, mid + 1, right);

        return invCount;
    }

    private static long mergeAndCount(long[] a, long[] b, int left, int mid, int right) {
        long invCount = 0;
        int i = left;
        int j = mid;
        int k = left;

        while (i <= mid - 1 && j <= right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                invCount = invCount + (mid - i);
            }
        }
        while (i <= mid - 1)
            b[k++] = a[i++];
        while (j <= right) {
            b[k++] = a[j++];
        }

        for (i = left; i <= right; i++) {
            a[i] = b[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long[] b = new long[n];
        System.out.println(mergeSort(a, b, 0, a.length - 1));
    }
}

