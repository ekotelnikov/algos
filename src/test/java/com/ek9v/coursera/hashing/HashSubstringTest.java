package com.ek9v.coursera.hashing;

import com.google.common.collect.ImmutableList;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 25.10.2017.
 */
public class HashSubstringTest {

    @Test
    public void getOccurrencesFast_for2symbolsPattern() throws Exception {
        String text = "abcdefabcdef";
        String pattern = "de";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);

        assertThat(occur, is(ImmutableList.of(3, 9)));
    }

    @Test
    public void getOccurrencesFast_for1symbolsPattern() throws Exception {
        String text = "aaaaaaaaaaa";
        String pattern = "aaaaaaaaaaa";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);
        List<Integer> expOccur = HashSubstring.getOccurrences(pattern, text);

        assertThat(occur, is(expOccur));
    }

    @Test
    public void getOccurrencesFast_for3symbolsPattern() throws Exception {
        String text = "abcdefabcdef";
        String pattern = "def";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);
        List<Integer> expOccur = HashSubstring.getOccurrences(pattern, text);

        assertThat(occur, is(expOccur));
    }

    @Test
    public void getOccurrencesFast_caseSensitive() throws Exception {
        String text = "testTesttesT";
        String pattern = "Test";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);

        assertThat(occur, is(ImmutableList.of(4)));
    }

    @Test
    public void getOccurrencesFast_for5symbolsPattern() throws Exception {
        String text = "baaaaaaa";
        String pattern = "aaaaa";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);

        assertThat(occur, is(ImmutableList.of(1, 2, 3)));
    }
    
    @Test
    public void getOccurrencesFast_forLongPattern() throws Exception {
        StringBuilder sb = new StringBuilder(500_000);
        for (int i = 1; i <= 500_000 - 1; i++) {
            sb.append("z");
        }
        sb.append("z");
        String text = sb.toString();
        String pattern = "zzzzzz";
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);
        List<Integer> expOccur = HashSubstring.getOccurrences(pattern, text);

//        assertThat(occur, is(ImmutableList.of(499_999)));
        assertThat(occur, is(expOccur));
    }

    @Test
    public void getOccurrencesFast_forZPattern() throws Exception {
        StringBuilder sb = new StringBuilder(500_000);
        for (int i = 1; i <= 500_000; i++) {
            sb.append("z");
        }

        StringBuilder p = new StringBuilder(250_000);
        for (int i = 1; i <= 250_000; i++) {
            p.append("z");
        }

        String text = sb.toString();
        String pattern = p.toString();
        List<Integer> occur = HashSubstring.getOccurrencesFast(text, pattern);
        List<Integer> expOccur = HashSubstring.getOccurrences(pattern, text);

//        assertThat(occur, is(ImmutableList.of(499_999)));
        assertThat(occur, is(expOccur));
    }
}