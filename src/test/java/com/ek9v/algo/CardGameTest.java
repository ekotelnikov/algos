package com.ek9v.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 14.02.2018.
 */
public class CardGameTest {

    private static final String CARDS = "23456789TJQKA";

    @Test
    public void playGameOne() throws Exception {
        String a = "A";
        String b = "A";

        assertThat(solution(a,b), is(1));
    }

    @Test
    public void playGameTwo() throws Exception {
        String a = "23456789";
        String b = "AKQJT99T";
        assertThat(solution(a, b), is(0));
    }

    @Test
    public void playGameThree() throws Exception {
        String a = "23456789";
        String b = "23456789";
        assertThat(solution(a, b), is(0));
    }

    @Test
    public void playGameFour() throws Exception {
        String a = "AAAAAAA";
        String b = "2222222";
        assertThat(solution(a, b), is(7));
    }

    private int solution(String A, String B) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            char cardA = A.charAt(i);
            char cardB = B.charAt(i);
            if (CARDS.indexOf(cardA) > CARDS.indexOf(cardB)) {
                result++;
            }
        }
        return result;
    }


}
