package com.ek9v.coursera.divideConquer;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 24.09.2017.
 */
public class InversionsTest {
    @Test
    public void getNumberOfInversions() throws Exception {
        long[] a = {2, 3, 9, 2, 9};
        long[] b = new long[5];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(2, inv);
        assertThat(b, is(new long[] {2, 2, 3, 9, 9}));
    }

    @Test
    public void getNumberOfInversions_noSplitInversions() throws Exception {
        long[] a = {3, 2, 1, 6, 5, 4};
        long[] b = new long[6];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(6, inv);
        assertThat(b, is(new long[] {1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void getNumberOfInversions_forSortedArray() throws Exception {
        long[] a = {1, 3, 5, 6, 9};
        long[] b = new long[5];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(0, inv);
        assertThat(b, is(new long[] {1, 3, 5, 6, 9}));
    }

    @Test
    public void getNumberOfInversions_forInvertedArray() throws Exception {
        long[] a = {9, 6, 5, 3, 1};
        long[] b = new long[5];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(10, inv);
        assertThat(b, is(new long[] {1, 3, 5, 6, 9}));
    }

    @Test
    public void getNumberOfInversions_forInvertedArray2() throws Exception {
        long[] a = {9, 8, 7, 3, 2, 1, 0};
        long[] b = new long[7];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(21, inv);
        assertThat(b, is(new long[] {0, 1, 2, 3, 7, 8, 9}));
    }

    @Test
    public void getNumberOfInversions_forElementArray() throws Exception {
        long[] a = {1};
        long[] b = new long[1];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(0, inv);
        assertThat(b, is(new long[] {1}));
    }

    @Test
    public void getNumberOfInversions_forEqualArray() throws Exception {
        long[] a = {1, 1, 1, 1, 1};
        long[] b = new long[5];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(0, inv);
        assertThat(b, is(new long[] {1, 1, 1, 1, 1}));
    }

    @Test
    public void getNumberOfInversions_forHugeDecreasingArray() throws Exception {
        long[] a = new long[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1_000_000_000 - i;
        }
        long[] b = new long[100_000];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(4_999_950_000L, inv);
    }

    @Test
    public void getNumberOfInversions_forHugeEqualArray() throws Exception {
        long[] a = new long[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1_000_000_000;
        }
        long[] b = new long[100_000];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(0, inv);
    }

    @Test
    public void getNumberOfInversions_forHugeSortedArray() throws Exception {
        long[] a = new long[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long[] b = new long[100_000];
        long inv = Inversions.mergeSort(a, b, 0, a.length - 1);
        assertEquals(0, inv);
    }

}