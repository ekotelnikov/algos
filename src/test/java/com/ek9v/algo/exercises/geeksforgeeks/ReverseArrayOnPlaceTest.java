package com.ek9v.algo.exercises.geeksforgeeks;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 02.09.2017.
 */
@RunWith(DataProviderRunner.class)
public class ReverseArrayOnPlaceTest {

    @Test
    public void shouldReturnEmptyArr_whenReverseEmptyArr() throws Exception {
        int[] arr = new int[] {};
        ReverseArrayOnPlace reverser = new ReverseArrayOnPlace(arr);
        int[] reverted = reverser.reverse();
        assertThat(reverted, is(arr));
    }

    @Test
    public void shouldReturnOneElementArr_whenReverseOneElementArr() throws Exception {
        int[] arr = new int[] {1};
        ReverseArrayOnPlace reverser = new ReverseArrayOnPlace(arr);
        int[] reverted = reverser.reverse();
        assertThat(reverted, is(arr));
    }

    @DataProvider
    public static Object[][] arrays() {
        return new Object[][]{
                {new int[] {1, 2}, new int[] {2, 1}},
                {new int[] {1, 2, 3}, new int[] {3, 2, 1}},
                {new int[] {-1, 2, 3}, new int[] {3, 2, -1}},
                {new int[] {-1, -2, -3}, new int[] {-3, -2, -1}},
                {new int[] {1, 2, 3, 4}, new int[] {4, 3, 2, 1}},
        };
    }

    @Test
    @UseDataProvider("arrays")
    public void shouldReverseArr_whenArrWith2Elements(int[] input, int[] expected) throws Exception {
        ReverseArrayOnPlace reverser = new ReverseArrayOnPlace(input);
        assertThat(reverser.reverse(), is(expected));
    }
}