package com.ek9v.coursera.basicDataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10.10.2017.
 */
public class CheckBracketsTest {
    @Test
    public void checkBrackets_forEmptyText() throws Exception {
        String text = "";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(0, ans);
    }

    @Test
    public void checkBrackets_forNoBracketsText() throws Exception {
        String text = "12345";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(0, ans);
    }

    @Test
    public void checkBrackets_forValidBracketsText() throws Exception {
        String text = "(1[2{3}4]5)";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(0, ans);
    }

    @Test
    public void checkBrackets_forNoValidCloseBracketsText() throws Exception {
        String text = "(1[2}3}4]5)";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(5, ans);
    }

    @Test
    public void checkBrackets_forNoValidCloseBracketsTextAtStart() throws Exception {
        String text = "]1[2{3}4]5)";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(1, ans);
    }

    @Test
    public void checkBrackets_forNoValidCloseBracketsTextAtEnd() throws Exception {
        String text = "1[2{3}4]5)))";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(10, ans);
    }

    @Test
    public void checkBrackets_forNoValidOpenBracketsTextAtStart() throws Exception {
        String text = "(((((";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(1, ans);
    }

    @Test
    public void checkBrackets_forNoValidOpenBracketsTextAtEnd() throws Exception {
        String text = "([]){";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(5, ans);
    }

    @Test
    public void checkBrackets_forNoValidOpenBracketsText() throws Exception {
        String text = "(1[2{3}4]5";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(1, ans);
    }

    @Test
    public void checkBrackets_forNoValidOpenBracketsText2() throws Exception {
        String text = "(1[2{3}4)";
        int ans = CheckBrackets.checkBrackets(text);
        assertEquals(9, ans);
    }

}