package com.ek9v.coursera.introduction;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 16.09.2017.
 */
public class FibonacciHugeTest {
    @Test
    public void getFibonacciHugeNaive() throws Exception {
        assertEquals(1, FibonacciHuge.getFibonacciHugeNaive(1, 239));
    }

    @Test
    public void getFibonacciHugeFast_239_1000() throws Exception {
        assertEquals(161, FibonacciHuge.getFibonacciHugeFast(239, 1000));
    }

    @Test
    public void getFibonacciHugeFast_2015_3() throws Exception {
        assertEquals(1, FibonacciHuge.getFibonacciHugeFast(2015, 3));
        assertEquals(0, FibonacciHuge.getFibonacciHugeFast(99999999999999999L, 2));
    }

    @Test
    public void getFibonacciHugeFast_huge() throws Exception {
        assertEquals(10249, FibonacciHuge.getFibonacciHugeFast(2816213588L, 30524));
    }

    @Test
    public void getLengthPisanoPeriod() throws Exception {
        assertEquals(8, FibonacciHuge.getPisanoLength(3));
        assertEquals(3, FibonacciHuge.getPisanoLength(2));
        assertEquals(60, FibonacciHuge.getPisanoLength(10));
    }
}