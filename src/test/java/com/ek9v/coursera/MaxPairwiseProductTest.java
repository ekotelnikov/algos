package com.ek9v.coursera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 07.09.2017.
 */
public class MaxPairwiseProductTest {

    @Test
    public void getMaxPairwiseProduct() throws Exception {
        int input[] = new int[] {100_000, 90_000};

        assertEquals(9_000_000_000L, MaxPairwiseProduct.getMaxPairwiseProductFast(input));
    }

}