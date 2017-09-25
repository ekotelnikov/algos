package com.ek9v.coursera.divideConquer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23.09.2017.
 */
public class BinarySearchTest {
    @Test
    public void binarySearch_existingElement() throws Exception {
        assertEquals(2, BinarySearch.binarySearch(new int[] {1, 3, 5, 8}, 5));
    }

    @Test
    public void binarySearch_nonExistingElement() throws Exception {
        assertEquals(-1, BinarySearch.binarySearch(new int[] {1, 3, 5, 8}, 0));
    }

    @Test
    public void binarySearch_worstCase() throws Exception {
        assertEquals(4, BinarySearch.binarySearch(new int[] {1, 3, 5, 8, 9}, 9));
    }

    @Test
    public void binarySearch_equalCase() throws Exception {
        assertEquals(2, BinarySearch.binarySearch(new int[] {1, 1, 1, 1, 1}, 1));
    }

    @Test
    public void binarySearch_oneElementArray() throws Exception {
        assertEquals(0, BinarySearch.binarySearch(new int[] {1}, 1));
    }

    @Test
    public void binarySearch_manyElementArray() throws Exception {
        assertEquals(-1, BinarySearch.binarySearch(new int[] {1,5,8,12,13}, 23));
    }



}