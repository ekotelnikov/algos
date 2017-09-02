package com.ek9v.algo.lafore;

import java.util.Stack;

/**
 * Parser of arithm expression to postfix form.
 */
public class PostfixParserOld {
    private final String expression;

    public PostfixParserOld(String exp) {
        this.expression = exp;
    }

    public String parse() {
        StringBuilder outExpBuilder = new StringBuilder();
        Stack<Character> opStack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                opStack.push(ch);
            } else if (ch == ')') {
                outExpBuilder.append(parseCloseBkt(opStack));
            } else if (isOperator(ch)) {
                outExpBuilder.append(parseOperator(opStack, ch));
            } else {
                outExpBuilder.append(ch);
            }
        }
        while (!opStack.isEmpty()) {
            outExpBuilder.append(opStack.pop());
        }

        return outExpBuilder.toString();
    }

    private String parseOperator(Stack<Character> opStack, char ch) {
        StringBuilder out = new StringBuilder();
        if (!opStack.isEmpty()) {
            char prevOp = opStack.pop();
            if (getPrior(prevOp) >= getPrior(ch)) {
                out.append(prevOp);
            } else {
                opStack.push(prevOp);
            }
        }
        opStack.push(ch);
        return out.toString();
    }

    private String parseCloseBkt(Stack<Character> opStack) {
        StringBuilder out = new StringBuilder();
        while (!opStack.isEmpty()) {
            char c = opStack.pop();
            if (c == '(') {
                break;
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    private int getPrior(char ch) {
        switch (ch) {
            case '(' : return 0;
            case '+' : return 1;
            case '-' : return 1;
            case '*' : return 2;
            case '/' : return 2;
            default: return 2;
        }
    }

    public static boolean isOperator(char ch) {
        switch (ch) {
            case '+' : return true;
            case '-' : return true;
            case '*' : return true;
            case '/' : return true;
            default: return false;
        }
    }
}
