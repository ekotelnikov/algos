package com.ek9v.algo.exercises.hackerrank;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

/**
 * Created by user on 20.06.2018.
 */
public class DynArrayXorTest {

    @Test
    public void doInBatch() throws Exception {
        DynArrayXor da = new DynArrayXor(2);
        int[][] queries = new int[5][3];
        queries[0] = new int[]{1, 0, 5};
        queries[1] = new int[]{1, 1, 7};
        queries[2] = new int[]{1, 0, 3};
        queries[3] = new int[]{2, 1, 0};
        queries[4] = new int[]{2, 1, 1};

        int[] answers = da.doInBatch(queries);
        assertThat(answers[0], is(7));
        assertThat(answers[1], is(3));
    }

    @Test
    public void doInBatch_whenQueryHuge() throws Exception {
        DynArrayXor da = new DynArrayXor(1);
        int[][] queries = new int[10_000][3];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[] {i % 2 + 1, 1_000_000_000, 0};
        }
        int[] a = da.doInBatch(queries);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testDynArray() throws Exception {
        DynArrayXor dynArrayXor = new DynArrayXor(2);
        dynArrayXor.doQuery(1, 0, 5);
        dynArrayXor.doQuery(1, 1, 7);
        dynArrayXor.doQuery(1, 0, 3);
        assertThat(dynArrayXor.doQuery(2, 1, 0), is(7));
        assertThat(dynArrayXor.doQuery(2, 1, 1), is(3));
    }

    @Test
    public void testZeros() throws Exception {
        DynArrayXor dynArrayXor = new DynArrayXor(2);
        dynArrayXor.doQuery(1, 0, 0);
        dynArrayXor.doQuery(1, 0, 0);
        dynArrayXor.doQuery(1, 1, 0);
        dynArrayXor.doQuery(1, 1, 0);
        assertThat(dynArrayXor.doQuery(2, 0, 0), is(0));
        assertThat(dynArrayXor.doQuery(2, 1, 0), is(0));
    }
}
