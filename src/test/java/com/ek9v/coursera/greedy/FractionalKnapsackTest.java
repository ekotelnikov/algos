package com.ek9v.coursera.greedy;

import org.junit.Assert;
import org.junit.Test;

import static com.ek9v.coursera.greedy.FractionalKnapsack.getOptimalValue;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class FractionalKnapsackTest {

    @Test
    public void getOptimalValue_forZeroCapacity() throws Exception {
        int[] values = {1};
        int[] weights = {1};
        assertEquals(0, getOptimalValue(0, values, weights), 0.00009);
    }

    @Test
    public void getOptimalValue_sample1() throws Exception {
        int[] values = {60, 100, 120};
        int[] weights = {20, 50, 30};
        assertEquals(180, getOptimalValue(50, values, weights), 0.00001);
    }

    @Test
    public void getOptimalValue_sample2() throws Exception {
        int[] values = {500};
        int[] weights = {30};
        assertEquals(166.6667, getOptimalValue(10, values, weights), 0.00009);
    }

    @Test
    public void getOptimalValue_whenWeightLessThenCapacity() throws Exception {
        int[] values = {60, 100, 120};
        int[] weights = {20, 50, 30};
        assertEquals(280, getOptimalValue(101, values, weights), 0.00001);
    }

    @Test
    public void getOptimalValue_whenWeightsAreEqual() throws Exception {
        int[] values = {60, 60, 60};
        int[] weights = {20, 20, 20};
        assertEquals(180, getOptimalValue(60, values, weights), 0.00001);
    }

    @Test
    public void getOptimalValue_huge() throws Exception {
        int[] values = new int[1_000];
        int[] weights = new int[1_000];

        for (int i = 0; i < values.length; i++) {
            values[i] = 2_000;
            weights[i] = 2_000;
        }

        assertEquals(2_000_000, getOptimalValue(2_000_000, values, weights), 0.00001);
    }
}