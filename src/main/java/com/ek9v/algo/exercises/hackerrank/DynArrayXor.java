package com.ek9v.algo.exercises.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href='https://www.hackerrank.com/challenges/dynamic-array/problem'>
 *     PracticeData StructuresArraysDynamic Array
 *     </a>.
 */
public class DynArrayXor {

    private int lastAnswer = 0;
    private final int n;
    private final List<Integer>[] seqList;

    public DynArrayXor(int n) {
        this.n = n;
        seqList = new List[n];
    }

    public int[] doInBatch(int[][] queries) {
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int a = doQuery(queries[i][0], queries[i][1], queries[i][2]);
            if (a >= 0) {
                answers.add(a);
            }
        }
        return answers.stream().mapToInt(a -> a).toArray();
    }

    public int doQuery(int queryType, int x, int y) {
        switch (queryType) {
            case 1:
                write(x, y);
                return -1;
            case 2:
                int index = (x ^ lastAnswer) % n;
                List<Integer> seq = seqList[index];
                lastAnswer = seq.get(y % seq.size());
                return lastAnswer;
            default:
                return -1;
        }
    }

    private void write(int x, int y) {
        int index = (x ^ lastAnswer) % n;
        if (seqList[index] == null) {
            seqList[index] = new ArrayList<>();
        }
        List<Integer> seq = seqList[index];
        seq.add(y);
    }
}
