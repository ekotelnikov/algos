package com.ek9v.coursera.introduction;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 16.09.2017.
 */
public class LCMTest {

    @Test
    public void lcm_naive() throws Exception {
        assertEquals(24, LCM.lcm_naive(6, 8));
    }

    @Test
    public void lcm_fast() throws Exception {
        assertEquals(24, LCM.lcm_fast(6, 8));
    }

    @Ignore("too long")
    @Test
    public void lcm_naive_huge() throws Exception {
        assertEquals(24, LCM.lcm_naive(28851538, 1183019));
    }

    @Test
    public void lcm_fast_huge() throws Exception {
        assertEquals(1933053046, LCM.lcm_fast(28851538, 1183019));
    }

}