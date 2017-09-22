package com.ek9v.coursera.greedy;

import org.junit.Test;

import static com.ek9v.coursera.greedy.Change.getChange;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class ChangeTest {

    @Test
    public void getChange_for1() throws Exception {
        assertEquals(1, getChange(1));
    }

    @Test
    public void getChange_for5() throws Exception {
        assertEquals(1, getChange(5));
    }

    @Test
    public void getChange_for7() throws Exception {
        assertEquals(3, getChange(7));
    }

    @Test
    public void getChange_for10() throws Exception {
        assertEquals(1, getChange(10));
    }

    @Test
    public void getChange_for16() throws Exception {
        assertEquals(3, getChange(16));
    }

    @Test
    public void getChange_for1000() throws Exception {
        assertEquals(100, getChange(1000));
    }
}