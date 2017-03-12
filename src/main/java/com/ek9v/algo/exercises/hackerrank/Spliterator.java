package com.ek9v.algo.exercises.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.02.2017.
 */
public class Spliterator {
    int[] w = {1, 2, 5};
    List<List<Integer>> kList = new ArrayList<>();

    public Spliterator() {
        kList.add(0, new ArrayList<>());
    }

    List<Integer> splitDiff(int diff) {
        if (diff < kList.size()) {
            return kList.get(diff);
        }
        for (int i = 1; i <= diff; i++) {
            if (kList.size() > i) {
                continue;
            }
            List<List<Integer>> pAll = new ArrayList<>();
            for (int j = 0; j < w.length && w[j] <= i; j++) {
                List<Integer> p = new ArrayList<>();

                p.addAll(kList.get(i - w[j]));
                p.add(w[j]);
                pAll.add(p);
            }
            List<Integer> pMin = getListWithMinSize(pAll);
            kList.add(pMin);
        }
        return kList.get(kList.size() - 1);
    }

    private List<Integer> getListWithMinSize(List<List<Integer>> pAll) {
        int minSize = pAll.get(0).size();
        List<Integer> pMin = pAll.get(0);
        for (List<Integer> p : pAll) {
            if (p.size() < minSize) {
                minSize = p.size();
                pMin = p;
            }
        }
        return pMin;
    }
}
