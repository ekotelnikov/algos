package com.ek9v.algo.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.is;

/**
 * Created by user on 16.12.2017.
 */
public class StringTwinsTest {

    @Test
    public void testTwins() throws Exception {
        String[] ans = twins(
                new String[]{"cdab","dcba", "abc", "ba ", "abcd", "a"},
                new String[]{"abcd","abcd","ab", "ab ", "bcda", "ab"});
        Assert.assertThat(ans[0], is("Yes"));
        Assert.assertThat(ans[1], is("No"));
        Assert.assertThat(ans[2], is("No"));
        Assert.assertThat(ans[3], is("No"));
        Assert.assertThat(ans[4], is("No"));
        Assert.assertThat(ans[5], is("No"));
    }

    static String[] twins(String[] a, String[] b)
    {
        String[] ans = new String[a.length];
        for (int i = 0; i < a.length; i++) {
//            if (a[i].length() != b[i].length()) {
//                ans[i] = "No";
//            } else {
                ans[i] = isTwins(a[i],b[i]) ? "Yes" : "No";
//            }
        }
        return ans;
    }

    private static boolean isTwins(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char a = 0b111;
        Set<Integer> set = new HashSet<>();
        int num = (int)50L;
        for (int i = 0; i < s1.length(); i++) {
            int i2 = s2.indexOf(s1.charAt(i));
            if (i2 == -1) {
                return false;
            }
            if (i % 2 != i2 %2) {
                return false;
            }
        }
        return true;
    }
}
