package com.ek9v.algo.exercises.hackerrank;

import java.util.Stack;

/**
 * Solution for <a href='https://www.hackerrank.com/challenges/maximum-element/problem'>
 *     PracticeData StructuresStacksMaximum Element
 *     </a>
 */
public class MaxStackElement {

    private final Stack<StackNode> values = new Stack<>();
    private Integer max;

    MaxStackElement() {
        this.max = Integer.MIN_VALUE;
    }

    public void pop() {
        values.pop();
        if (values.isEmpty()) {
            max = Integer.MIN_VALUE;
        } else {
            max = values.peek().curMax;
        }
    }

    public int getMax() {
        return values.peek().curMax;
    }

    public void push(int value) {
        if (max < value) {
            max = value;
        }
        values.push(new StackNode(value, max));
    }

    private class StackNode {

        private final int value;
        private final int curMax;

        public StackNode(int value, int max) {
            this.value = value;
            this.curMax = max;
        }
    }
}
