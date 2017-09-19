package com.ek9v.coursera.introduction;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 16.09.2017.
 */
public class FibonacciLastDigitTest {
    @Test
    public void getFibonacciLastDigitNaive_forHugeNumber() throws Exception {
        assertEquals(5, FibonacciLastDigit.getFibonacciLastDigitNaive(10_000_000));
    }

    @Test
    public void getFibonacciLastDigitNaive_forZero() throws Exception {
        assertEquals(0, FibonacciLastDigit.getFibonacciLastDigitNaive(0));
    }

    @Test
    public void getFibonacciLastDigitNaive_forFive() throws Exception {
        assertEquals(5, FibonacciLastDigit.getFibonacciLastDigitNaive(5));
    }

    @Test
    public void getFibonacciLastDigitNaive_for7() throws Exception {
        assertEquals(3, FibonacciLastDigit.getFibonacciLastDigitNaive(7));
    }

}