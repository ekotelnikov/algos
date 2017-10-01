package com.ek9v.coursera.divideConquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 27.09.2017.
 */
public class PointsAndSegmentsTest {

    @Test
    public void fastCountSegments() throws Exception {
        int[] starts = {0, 7};
        int[] ends = {5, 10};
        int[] points = {1, 6, 11};

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertThat(out, is(new int[] {1, 0, 0}));
    }

    @Test
    public void fastCountSegments_lessThenMinPoint() throws Exception {
        int[] starts = {0, 7};
        int[] ends = {5, 9};
        int[] points = {12, 13, 10};

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertThat(out, is(new int[] {0, 0, 0}));
    }

    @Test
    public void fastCountSegments_greaterThenMaxPoint() throws Exception {
        int[] starts = {15, 17};
        int[] ends = {18, 21};
        int[] points = {12, 13, 10};

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertThat(out, is(new int[] {0, 0, 0}));
    }

    @Test
    public void fastCountSegments_allInPoints() throws Exception {
        int[] starts = {15, 17, 14};
        int[] ends = {18, 21, 22};
        int[] points = {14, 19, 22};

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertThat(out, is(new int[] {1, 2, 1}));
    }

    @Test
    public void fastCountSegments_equalsSegments() throws Exception {
        int[] starts = new int[50_000];
        int[] ends = new int[50_000];
        Arrays.fill(ends, 1);
        int[] points = new int[50_000];

        int[] expected = new int[50_000];
        Arrays.fill(expected, 50_000);

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertThat(out, is(expected));
    }

    @Test
    public void fastCountSegments_forAllInterval() throws Exception {
        int[] starts = new int[50_000];
        int[] ends = new int[50_000];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = i;
            ends[i] = i + 1;
        }

        int[] points = new int[50_000];
        for (int i = 0; i < points.length; i++) {
            points[i] = i;
        }

        int[] expected = new int[50_000];
        Arrays.fill(expected, 2);
        expected[0] = 1;

        int[] out = PointsAndSegments.fastCountSegments(starts, ends, points);
        assertEquals(expected.length, out.length);
        assertThat(out, is(expected));
    }

}