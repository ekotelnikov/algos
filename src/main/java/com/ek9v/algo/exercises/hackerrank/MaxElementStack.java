package com.ek9v.algo.exercises.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by user on 17.06.2018.
 */
public class MaxElementStack {
    private static class MaxStackElement {

        private final Stack<StackNode> values = new Stack<>();
        private Integer max;

        MaxStackElement() {
            this.max = Integer.MIN_VALUE;
        }

        private void pop() {
            values.pop();
            if (values.isEmpty()) {
                max = Integer.MIN_VALUE;
            } else {
                max = values.peek().curMax;
            }
        }

        private int getMax() {
            return values.peek().curMax;
        }

        private void push(int value) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        MaxStackElement m = new MaxStackElement();
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    int value = sc.nextInt();
                    m.push(value);
                    break;
                case 2:
                    m.pop();
                    break;
                case 3:
                    System.out.println(m.getMax());
                    break;
            }
        }
    }
}
