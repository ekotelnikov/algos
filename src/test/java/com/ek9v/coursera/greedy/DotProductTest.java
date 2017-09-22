package com.ek9v.coursera.greedy;

import org.junit.Test;

import static com.ek9v.coursera.greedy.DotProduct.maxDotProduct;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class DotProductTest {

    @Test
    public void maxDotProduct_sample1() throws Exception {
        int[] a = {23};
        int[] b = {39};

        assertEquals(897, maxDotProduct(a, b));
    }

    @Test
    public void maxDotProduct_sample2() throws Exception {
        int[] a = {1, 3, -5};
        int[] b = {-2, 4, 1};
        assertEquals(23, maxDotProduct(a, b));
    }

    @Test
    public void maxDotProduct_equals() throws Exception {
        int[] a = {1, 1, 1};
        int[] b = {5, 5, 5};
        assertEquals(15, maxDotProduct(a, b));
    }

    @Test
    public void maxDotProduct_negativePositive() throws Exception {
        int[] a = {-1, -2, -3};
        int[] b = {1, 2, 3};
        assertEquals(-10, maxDotProduct(a, b));
    }

    @Test
    public void maxDotProduct_huge() throws Exception {
        int[] a = new int[1000];
        int[] b = new int[1000];

        for (int i = 0; i < a.length; i++) {
            a[i] = 100_000;
            b[i] = -100_000;
        }

        assertEquals(-10_000_000_000_000L, maxDotProduct(a, b));
    }
}