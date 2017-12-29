package com.ek9v.algo.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 16.12.2017.
 */
public class CountSortingOne {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[100];
        for (int i = 1; i <= n; i++) {
            arr[in.nextInt()]++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

}
