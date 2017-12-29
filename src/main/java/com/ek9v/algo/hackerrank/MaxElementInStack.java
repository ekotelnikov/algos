package com.ek9v.algo.hackerrank;

import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by user on 16.12.2017.
 */
public class MaxElementInStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> elements = new Stack<>();
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            processLineByType(sc, elements, type);
        }
    }

    private static void processLineByType(Scanner sc, Stack<Integer> elements, int type) {
        switch (type) {
            case 1:
                int elem = sc.nextInt();
                elements.push(elem);
                break;
            case 2:
                if (!elements.isEmpty()) {
                    elements.pop();
                }
                break;
            case 3:
                getMaxElement(elements).ifPresent(System.out::println);
                break;
        }
    }

    private static Optional<Integer> getMaxElement(Stack<Integer> elements) {
        Integer max = null;

        while (!elements.isEmpty()) {
            int item = elements.pop();
            max = max == null || max < item ? item : max;
        }

        return Optional.ofNullable(max);
    }

}
