package com.ek9v.algo.exercises.geeksforgeeks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 01.09.2017.
 */
public class MaximumIndexDiffTest {

    @Test
    public void shouldReturn1_for2elementsArray() throws Exception {
        int[] arr = new int[] {1,10};
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
        assertEquals(1, maxIndex.calc());
    }

    @Test
    public void shouldReturn2_for3elementsArray() throws Exception {
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(new int[] {3, 5, 4, 2});
        assertEquals(2, maxIndex.calc());
    }

    @Test
    public void shouldReturnMinus1_forRevertedArray() throws Exception {
        int[] arr = {5, 4, 3, 2, 1};
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
        assertEquals(-1, maxIndex.calc());
    }

    @Test
    public void shouldReturnMaxDiff_forArray() throws Exception {
        int[] arr = {6, 7, 3, 2, 1, 5};
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
        assertEquals(3, maxIndex.calc());
    }

    @Test
    public void shouldReturnZero_forOneElementArray() throws Exception {
        int[] arr = {17};
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
        assertEquals(0, maxIndex.calc());
    }

    @Test
    public void shouldReturnLength_forEqualArray() throws Exception {
        int[] arr = {2, 2, 2, 2, 2};
        MaximumIndexDiff maxIndex = new MaximumIndexDiff(arr);
        assertEquals(4, maxIndex.calc());
    }
}