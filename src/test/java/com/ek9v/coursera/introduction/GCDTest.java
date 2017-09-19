package com.ek9v.coursera.introduction;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 16.09.2017.
 */
public class GCDTest {
    @Test
    public void gcd_naive() throws Exception {
        Assert.assertEquals(1, GCD.gcd_naive(18, 35));
    }

    @Test
    public void gcd_naive_huge() throws Exception {
        Assert.assertEquals(17657, GCD.gcd_naive(28851538, 1183019));
    }

}