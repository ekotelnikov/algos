package com.ek9v.coursera.greedy;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class DifferentSummandsTest {


    @Test
    public void optimalSummands_for8() throws Exception {
        List<Integer> expected = Lists.newArrayList(1, 2, 5);
        assertThat(DifferentSummands.optimalSummands(8), is(expected));
    }

    @Test
    public void optimalSummands_for6() throws Exception {
        List<Integer> expected = Lists.newArrayList(1, 2, 3);
        assertThat(DifferentSummands.optimalSummands(6), is(expected));
    }

    @Test
    public void optimalSummands_for1() throws Exception {
        List<Integer> expected = Lists.newArrayList(1);
        assertThat(DifferentSummands.optimalSummands(1), is(expected));
    }

    @Test
    public void optimalSummands_for2() throws Exception {
        List<Integer> expected = Lists.newArrayList(2);
        assertThat(DifferentSummands.optimalSummands(2), is(expected));
    }

    @Test
    public void optimalSummands_forBillion() throws Exception {
        List<Integer> actual = DifferentSummands.optimalSummands(1_000_000_000);

        assertThat(actual, not(emptyCollectionOf(Integer.class)));
        for (int i = 0; i < actual.size() - 1; i++) {
            assertThat(actual.get(i+1), Matchers.greaterThan(actual.get(i)));
        }
    }


}