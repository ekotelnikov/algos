package com.ek9v.coursera.dynProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 04.10.2017.
 */
public class KnapsackTest {
    @Test
    public void optimalWeight() throws Exception {
        int w = Knapsack.optimalWeight(10, new int[] {0, 1, 4, 8});
        assertEquals(9, w);
    }

    @Test
    public void optimalWeight6342() throws Exception {
        int w = Knapsack.optimalWeight(10, new int[] {6, 3, 4, 2});
        assertEquals(10, w);
    }

    @Test
    public void optimalWeightMax() throws Exception {
        int[] w1 = new int[300];
        for (int i = 0; i < w1.length - 2; i++) {
            w1[i] = i;
        }
        w1[w1.length - 1] = 100_000;
        int w = Knapsack.optimalWeight(10_000, w1);
        assertEquals(10_000, w);
    }

}