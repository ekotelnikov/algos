package com.ek9v.coursera.basicDataStructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 09.12.2017.
 */
public class Brackets {

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements)
    {
        int[] replacements = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            replacements[i] = replace(expressions[i]);
        }
        int[] result = new int[maxReplacements.length];
        for (int i = 0; i < replacements.length; i++) {
            result[i] = replacements[i] <= maxReplacements[i] ? 1 : 0;
        }
        return result;
    }

    private static int replace(String expression) {
        if (expression.charAt(expression.length() - 1) == '<') {
            return Integer.MAX_VALUE;
        }
        Stack<Character> openBrackets = new Stack<Character>();

        Stream.of("", "1").filter((s) -> s != null).collect(Collectors.toList());

        int r = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '<') {
                openBrackets.push(c);
            } else {
                if (openBrackets.isEmpty()) {
                    r++;
                } else {
                    openBrackets.pop();
                }
            }
        }

        return openBrackets.isEmpty() ? r : r > 0 ? Integer.MAX_VALUE : openBrackets.size();
    }

    @Test
    public void test() throws Exception {
        System.out.println(3%5);
        int[] r = balancedOrNot(new String[] {"<><>>>","<>><<>"}, new int[]{2, 2});

        Assert.assertArrayEquals(new int[] {1, 0}, r);
    }
}
