package com.ek9v.coursera.introduction;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16.09.2017.
 */
public class FibonacciTest {

    @Test
    public void calcZero() {
        assertEquals(0, Fibonacci.calc_fib(0));
    }

    @Test
    public void calcOne() throws Exception {
        assertEquals(1, Fibonacci.calc_fib(1));
    }

    @Test
    public void calc45() throws Exception {
        assertEquals(1134903170, Fibonacci.calc_fib(45));

    }
}