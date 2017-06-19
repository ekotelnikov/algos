package com.ek9v.algo.lafore;


import java.util.Stack;

/**
 * Calculator of postfix expressions.
 */
public class PostfixCalc {

    private final String postfixExp;

    public PostfixCalc(String postfixExp) {
        this.postfixExp = postfixExp;
    }

    public int calculate() {
        Stack<Integer> numbers = new Stack<>();

        char[] chars = postfixExp.toCharArray();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                numbers.push(Integer.valueOf(String.valueOf(ch)));
            } else {
                Integer n2 = numbers.pop();
                Integer n1 = numbers.pop();
                Integer result = getAnswer(n1, ch, n2);
                numbers.push(result);
            }
        }

        return numbers.pop();
    }

    private int getAnswer(Integer o1, char op, Integer o2) {
        switch (op) {
            case '+': return o1 + o2;
            case '-': return o1 - o2;
            case '*': return o1 * o2;
            case '/': return o1 / o2;
            default: return 0;
        }
    }
}
