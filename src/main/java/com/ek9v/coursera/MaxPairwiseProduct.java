package com.ek9v.coursera;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long product = (long) numbers[i] * (long) numbers[j];
                if (product > result) {
                    result = product;
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;

        int maxIndex1 = getMaxIndexOne(numbers);
        int maxIndex2 = getMaxIndexTwo(numbers, maxIndex1);

        result = (long) numbers[maxIndex1] * (long) numbers[maxIndex2];
        
        return result;
    }

    private static int getMaxIndexOne(int[] numbers) {
        int maxIndex1 = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }
        return maxIndex1;
    }

    private static int getMaxIndexTwo(int[] numbers, int maxIndex1) {
        int maxIndex2 = maxIndex1 == 0 ? 1 : 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex2] && i != maxIndex1) {
                maxIndex2 = i;
            }
        }
        return maxIndex2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
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