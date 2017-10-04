package com.ek9v.coursera.dynProgramming;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user on 02.10.2017.
 */
public class PrimitiveCalculatorTest {

    @Test
    public void optimal_sequence_for1() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(1);
        System.out.println(s);
        assertEquals(0, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for11() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(11);
        System.out.println(s);
        assertEquals(4, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for100() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(100);
        System.out.println(s);
        assertEquals(7, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for50() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(50);
        System.out.println(s);
        assertEquals(6, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for1_000_000() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(1_000_000);
        System.out.println(s);
        assertEquals(19, s.size() - 1);
    }

    @Ignore
    @Test
    public void optimal_sequence_stress_test() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimal_sequence(999972);
        System.out.println(s);
        assertEquals(18, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for9() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(9);
        System.out.println(s);
        assertEquals(2, s.size() - 1);
    }

    @Test
    public void optimal_sequence_for28() throws Exception {
        List<Integer> s = PrimitiveCalculator.optimalSequence(28);
        System.out.println(s);
        assertEquals(4, s.size() - 1);
    }

}