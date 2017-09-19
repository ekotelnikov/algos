package com.ek9v.coursera;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 09.09.2017.
 */
public class GCDTest {

    @Test
    public void calculateEvklidGTC() throws Exception {
        int gtc = GCD.calculate(10, 4);
        assertEquals(2, gtc);
    }

    @Test
    public void calculateBigEvklidGTC() throws Exception {
        int gtc = GCD.calculate(357, 234);
        assertEquals(3, gtc);
    }
}