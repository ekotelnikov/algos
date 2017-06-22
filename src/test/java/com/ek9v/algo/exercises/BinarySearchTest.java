package com.ek9v.algo.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 19.06.2017.
 */
public class BinarySearchTest {

    @Test
    public void binarySearch_equalArray_found() throws Exception {
        int[] arr = new int[] {0, 0, 0, 0};
        int result = BinarySearch.find(0, arr);
        Assert.assertThat(result, is(2));
    }

    @Test
    public void binarySearch_emptyArray_notFound() throws Exception {
        int[] arr = new int[] {};
        int result = BinarySearch.find(1, arr);
        Assert.assertThat(result, is(-1));
    }

    @Test
    public void binarySearch_oneElemArray_found() throws Exception {
        int[] arr = new int[] {-1};
        int result = BinarySearch.find(-1, arr);
        Assert.assertThat(result, is(0));
    }

    @Test
    public void binarySearch_intOddArray_notFound() throws Exception {
        int[] arr = new int[] {-1, 0, 2, 4, 7, 9, 15, 17};
        int result = BinarySearch.find(-3, arr);
        Assert.assertThat(result, is(-1));
    }

    @Test
    public void binarySearch_intEvenArray_notZeroResult() throws Exception {
        int[] arr = new int[] {-1, 2};
        int result = BinarySearch.find(2, arr);
        Assert.assertThat(result, is(1));
    }
}