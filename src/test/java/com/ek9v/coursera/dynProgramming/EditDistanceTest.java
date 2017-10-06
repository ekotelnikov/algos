package com.ek9v.coursera.dynProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 05.10.2017.
 */
public class EditDistanceTest {
    @Test
    public void editDistance_forTheSameStrings() throws Exception {
        int d = EditDistance.editDistance("ab", "ab");
        assertEquals(0, d);
    }

    @Test
    public void editDistance_forDiffStrings() throws Exception {
        int d = EditDistance.editDistance("editing", "distance");
        assertEquals(5, d);
    }

}