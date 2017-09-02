package com.ek9v.algo.lafore;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by user on 19.07.2017.
 */
public class Postfix {
    private final String expression;
    private final PostfixParser postfixParser = new PostfixParser();

    public Postfix(String expression) {
        this.expression = expression;
    }

    public int calculate() {
        if (StringUtils.isBlank(expression))
            throw new EmptyInputException();
        String postfixExp = postfixParser.parse(expression);
        return calculatePostfixExp(postfixExp);
    }

    private int calculatePostfixExp(String postfixExp) {
        return 0;
    }
}
