package com.ek9v.coursera.divideConquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 24.09.2017.
 */
public class SortingTest {
    @Test
    public void partition2() throws Exception {
        int[] a = new int[] {3, 5, 4, 3, 1, 0, 2, 3};
        Sorting.partition2(a, 0, 7);
        System.out.println(Arrays.toString(a));
//        Assert.assertThat(a, is(new int[] {3, 1, 4, 5, 4, 5}));
//        Assert.assertThat(p[0], is(2));
//        Assert.assertThat(p[1], is(3));
    }

    @Test
    public void partition3() throws Exception {
        int[] a = new int[] {3, 5, 4, 1, 3, 2};
        int[] p = Sorting.partition3(a, 0, 5);
        Assert.assertThat(a, is(new int[] {2, 1, 3, 3, 5, 4}));
        Assert.assertThat(p[0], is(2));
        Assert.assertThat(p[1], is(3));
    }

    @Test
    public void partition3_oneElementInMiddle() throws Exception {
        int[] a = new int[] {3, 5, 4, 1, 2};
        int[] p = Sorting.partition3(a, 0, 4);
        Assert.assertThat(a, is(new int[] {2, 1, 3, 5, 4}));
        Assert.assertThat(p[0], is(2));
        Assert.assertThat(p[1], is(2));
    }

    @Test
    public void partition3_manyElementsInMiddle() throws Exception {
        int[] a = new int[] {3, 5, 4, 3, 1, 2, 3};
        int[] p = Sorting.partition3(a, 0, 6);
        Assert.assertThat(a, is(new int[] {2, 1, 3, 3, 3, 4, 5}));
        Assert.assertThat(p[0], is(2));
        Assert.assertThat(p[1], is(4));
    }

    @Test
    public void partition3_oneElement() throws Exception {
        int[] a = new int[] {3};
        int[] p = Sorting.partition3(a, 0, 0);
        Assert.assertThat(p[0], is(0));
        Assert.assertThat(p[1], is(0));
        Assert.assertThat(a, is(new int[] {3}));
    }

    @Test
    public void partition3_equalElements() throws Exception {
        int[] a = new int[] {3, 3, 3, 3, 3};
        int[] p = Sorting.partition3(a, 0, 4);
        Assert.assertThat(p[0], is(0));
        Assert.assertThat(p[1], is(4));
        Assert.assertThat(a, is(new int[] {3, 3, 3, 3, 3}));
    }

}