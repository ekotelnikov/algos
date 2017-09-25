package com.ek9v.coursera.divideConquer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 23.09.2017.
 */
public class MajorityElementTest {
    @Test
    public void getMajorityElement() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {1, 1, 1, 2});
        Assert.assertEquals(1, r);
    }

    @Test
    public void getMajorityElement_inSecondHalf() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {2, 3, 9, 2, 2});
        Assert.assertEquals(2, r);
    }

    @Test
    public void getMajorityElement_inFirstHalf() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {2, 2, 9, 3, 2});
        Assert.assertEquals(2, r);
    }

    @Test
    public void getMajorityElement_noMajority() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {1, 2, 3, 4});
        Assert.assertEquals(-1, r);
    }

    @Test
    public void getMajorityElement_equalHalfs() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {1, 2, 1, 2});
        Assert.assertEquals(-1, r);
    }

    @Test
    public void getMajorityElement_equalHalfsPlusOne() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {1, 1, 1, 1, 7, 7});
        Assert.assertEquals(1, r);
    }

    @Test
    public void getMajorityElement_equalHalfsExceptOne() throws Exception {
        int r = MajorityElement.getMajorityElement(new int[] {1, 1, 2, 3, 4, 5, 6, 7});
        Assert.assertEquals(-1, r);
    }

    @Test
    public void getMajorityElement_hugeArray() throws Exception {
        int[] a = new int[100_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int r = MajorityElement.getMajorityElement(a);
        Assert.assertEquals(-1, r);
    }

    @Test
    public void getMajorityElement_hugeArrayWithMajorityElement() throws Exception {
        int[] a = new int[100_000];
        for (int i = 0; i < a.length / 2; i++) {
            a[i] = 1;
        }
        a[a.length / 2] = 1;
        for (int i = a.length / 2 + 1; i < a.length; i++) {
            a[i] = i;
        }
        int r = MajorityElement.getMajorityElement(a);
        Assert.assertEquals(1, r);
    }

}