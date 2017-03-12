package com.ek9v.algo.exercises.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 10.02.2017.
 */
public class Equal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int tc = 1;
        Equalizer equalizer = new Equalizer();
        while (tc <= t) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            equalizer.equalize2(a);
            System.out.println(equalizer.getOps());
            tc++;
        }
    }

    static class Equalizer {

        private Spliterator sp = new Spliterator();
        private int ops = 0;

        public int[] equalize(int[] a) {
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            ops = 0;

            int d = 0;
            int a_min = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] + d > a_min) {
                    int diff = a[i] + d - a_min;
                    if (diff > 2 && diff < 5 && i == 1 && a[i] <= 5) {
                        i--;
                        ops++;
                        d += 5 - diff;
                    } else  {
                        List<Integer> diffs = sp.splitDiff(diff);
                        ops += diffs.size();
                        a_min = a[i] + d;
                        d += diff;
                    }
                }
            }

            return a;
        }

        public int[] equalize2(int[] a) {
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            ops = 0;

            int d = 0;
            int a_min = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > a_min) {
                    int diff = a[i] - a_min;
                    int delta = 0;
                    if (diff > 2 && diff < 5 && a[1] == 5 && a[2] == 5) {
//                    if (diff > 2 && diff < 5 && i == 1 && a[i] <= 5 && a_min > 0) {
                        i--;
                        ops++;
                        delta = 5 - diff;
                    } else  {
                        List<Integer> diffs = sp.splitDiff(diff);
                        ops += diffs.size();
                        a_min = a[i];
                        delta = diff;
                    }
                    d += delta;
                    for (int j = 0; j < a.length; j++) {
                        if (i != j) {
                            a[j] += delta;
                        }
                    }
                    System.out.println(Arrays.toString(a));
                }
            }

            return a;
        }

        public int getOps() {
            return ops;
        }
    }

}
