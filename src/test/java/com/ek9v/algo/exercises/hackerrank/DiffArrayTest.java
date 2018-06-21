package com.ek9v.algo.exercises.hackerrank;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created by user on 21.06.2018.
 */
public class DiffArrayTest {


    @Test
    public void shouldFindMax_forSimpleArray() throws Exception {
        DiffArray m = new DiffArray(10);
        m.doOp(1, 5, 3);
        m.doOp(4, 8, 7);
        m.doOp(6, 9, 1);
        assertThat(m.getMax(), is(10L));

        DiffArray d = new DiffArray(5);
        d.doOp(1, 2, 100);
        d.doOp(2, 5, 100);
        d.doOp(3, 4, 100);
        assertThat(d.getMax(), is(200L));
    }

    @Test
    public void testInBatch() throws Exception {
        int[][] queries = new int[200_000][3];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[] {1, i + 1, 1_000_000_000};
        }

        DiffArray arr = new DiffArray(10_000_000);
        for (int i = 0; i < queries.length; i++) {
            arr.doOp(queries[i][0], queries[i][1], queries[i][2]);
        }

        assertThat(arr.getMax(), is(200_000_000_000_000L));
    }

}
