package com.ek9v.algo.exercises.hackerrank;

import java.util.*;

/**
 * Created by user on 12.02.2017.
 */
public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }

        CoinsSpliterator spliterator = new CoinsSpliterator(coins);
        Set<List<Integer>> s = spliterator.splitNum(num);
        System.out.println(s.size());
    }

    static class CoinsSpliterator {

        private final int[] w;
        private List<Set<List<Integer>>> kList = new ArrayList<>();

        CoinsSpliterator(int[] coins) {
            w = coins;

            Set<List<Integer>> emptyList = new LinkedHashSet<>();
            emptyList.add(new ArrayList<>());
            kList.add(0, emptyList);
        }

        Set<List<Integer>> splitNum(int num) {
            for (int i = 1; i <= num; i++) {
                Set<List<Integer>> pAll = new LinkedHashSet<>();
                for (int j = 0; j < w.length && w[j] <= i; j++) {
                    Set<List<Integer>> pre = kList.get(i - w[j]);
                    for (List<Integer> perm : pre) {
                        List<Integer> p = new ArrayList<>(perm);
                        if (!p.isEmpty() && w[j] >= p.get(p.size() - 1)) {
                            p.add(w[j]);
                        } else if (!p.isEmpty()) {
                            for (int k = 0; k < p.size(); k++) {
                                if (p.get(k) >= w[j]) {
                                    p.add(k, w[j]);
                                    break;
                                }
                            }
                        } else {
                            p.add(w[j]);
                        }
                        pAll.add(p);
                    }
                }
                kList.add(pAll);
            }
            return kList.get(kList.size() - 1);
        }
    }
}
