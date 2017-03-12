package com.ek9v.algo.exercises.hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 11.02.2017.
 */
public class EqualTest {

    @Test
    public void testSplitDiff() {
        Spliterator spliterator = new Spliterator();
        List<Integer> min = spliterator.splitDiff(11);
        System.out.println(min);
        min = spliterator.splitDiff(12);
        System.out.println(min);
    }

    @Test
    public void testEqualize() {
        int[] a = {2, 2, 3, 7};
        Equal.Equalizer e = new Equal.Equalizer();
        int[] out = e.equalize2(a);
        System.out.println(Arrays.toString(out));
        int ops = e.getOps();

        assertThat(ops, is(2));

        int[] a2 = {1, 1, 5, 9, 9};
        out = e.equalize2(a2);
        System.out.println(Arrays.toString(out));
        ops = e.getOps();

        assertThat(ops, is(8));
    }

    @Test
    public void testCase11() {
        int[] a = {1, 5, 5};
        Equal.Equalizer e = new Equal.Equalizer();
        int[] out = e.equalize2(a);
        System.out.println(Arrays.toString(out));
        int ops = e.getOps();

        assertThat(ops, is(3));
    }

    //1 5 5 10 10
    @Test
    public void testCase12() {
        int[] a = {1, 5, 5, 10, 10};
        Equal.Equalizer e = new Equal.Equalizer();
        int[] out = e.equalize2(a);
        System.out.println(Arrays.toString(out));
        int ops = e.getOps();

        assertThat(ops, is(7));
    }

    @Test
    public void testCase13() {
        int[] a = {2, 5, 5, 5, 5, 5};
        Equal.Equalizer e = new Equal.Equalizer();
        int[] out = e.equalize2(a);
        System.out.println(Arrays.toString(out));
        int ops = e.getOps();

        assertThat(ops, is(6));
    }

    @Test
    public void testCase2() {
        int[] a = {2, 5, 30, 33, 37, 59, 60, 68, 81, 148, 153, 154, 162, 171, 196, 210, 243, 245, 273, 282, 299, 307, 335, 355, 361, 365, 405, 411, 419, 435, 438, 442, 458, 463, 470, 478, 485, 497, 509, 517, 524, 556, 630, 683, 685, 685, 687, 695, 698, 700, 701, 706, 710, 724, 729, 764, 790, 809, 814, 839, 854, 913, 926, 958, 989, 990};

        Equal.Equalizer e = new Equal.Equalizer();
        int[] out = e.equalize2(a);
        System.out.println(Arrays.toString(out));
        int ops = e.getOps();

        assertThat(ops, is(6196));
    }
}