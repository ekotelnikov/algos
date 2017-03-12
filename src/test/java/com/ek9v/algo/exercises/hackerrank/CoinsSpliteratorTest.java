package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;

/**
 * Created by user on 11.02.2017.
 */
public class CoinsSpliteratorTest {
    @Test
    public void split4Diff() throws Exception {
        CoinChange.CoinsSpliterator spliterator = new CoinChange.CoinsSpliterator(new int[]{1,2,3});

        Set<List<Integer>> ways = spliterator.splitNum(4);

        Assert.assertThat(ways.size(), is(4));
    }

    @Test
    public void split10Diff() throws Exception {
        CoinChange.CoinsSpliterator spliterator = new CoinChange.CoinsSpliterator(new int[]{2,3,5,6});

        Set<List<Integer>> ways = spliterator.splitNum(10);
        System.out.println(ways);

        Assert.assertThat(ways.size(), is(5));
    }

    @Test
    public void split250Diff() throws Exception {
        int[] coins = new int[50];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = i + 1;
        }
        CoinChange.CoinsSpliterator spliterator = new CoinChange.CoinsSpliterator(coins);

        Set<List<Integer>> ways = spliterator.splitNum(250);
        System.out.println(ways);

        Assert.assertThat(ways.size(), is(5));
    }
}