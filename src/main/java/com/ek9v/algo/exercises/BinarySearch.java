package com.ek9v.algo.exercises;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by user on 19.06.2017.
 */
public class BinarySearch {

    public static int find(int e, int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        //TODO rewrite with low and high boundaries
        //use >>> instead of dividing.
        Stack stack = new Stack();
        stack.pop();
        Arrays.sort(arr);
        int m = arr.length / 2;
        do {
            if (e < arr[m]) {
                m = m / 2;
            } else if (e > arr[m]) {
                m = m + (arr.length - m) / 2;
            }
            if (e == arr[m]) {
                return m;
            }
        } while (m != 0 && m < arr.length - 1);
        return -1;
    }
}
