package com.ek9v.coursera.introduction;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 16.09.2017.
 */
public class FibonacciSumLastDigitTest {
    @Test
    public void getFibonacciSumNaive() throws Exception {
        assertEquals(0, FibonacciSumLastDigit.getFibonacciSumNaive(0));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSumNaive(5));
        assertEquals(3, FibonacciSumLastDigit.getFibonacciSumNaive(7));
        assertEquals(5, FibonacciSumLastDigit.getFibonacciSumNaive(100));
    }

    @Test
    public void getFibonacciSumFast() throws Exception {
        assertEquals(0, FibonacciSumLastDigit.getFibonacciSumFast(0));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSumFast(5));
        assertEquals(3, FibonacciSumLastDigit.getFibonacciSumFast(7));
        assertEquals(5, FibonacciSumLastDigit.getFibonacciSumFast(100));
        assertEquals(3, FibonacciSumLastDigit.getFibonacciSumFast(832564823476L));
        assertEquals(9, FibonacciSumLastDigit.getFibonacciSumFast(614162383528L));
    }

}