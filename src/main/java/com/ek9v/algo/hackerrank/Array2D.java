package com.ek9v.algo.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 14.12.2017.
 */
public class Array2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        System.out.println(maxSumHourglass(arr));
    }

    private static int maxSumHourglass(int[][] arr) {
        int maxSum = 0;
        for (int h_row = 2, l_row = 0; h_row < arr.length; h_row++, l_row++)
            for (int h_col = 2, l_col = 0; h_col < arr.length; h_col++, l_col++) {
                int sum = sumHourglass(arr, l_col, h_col, l_row, h_row);
                maxSum = sum > maxSum ? sum : maxSum;
            }

        return maxSum;
    }

    private static int sumHourglass(int[][] arr, int l_col, int h_col, int l_row, int h_row) {
        int sum = 0;
        for (int i = l_row; i <= h_row; i++) {
            for (int j = l_col; j <= h_col; j++) {
                if (i != (h_row + l_row)/2 || (j != l_col || j != h_col)) {
//                  System.out.print(arr[i][j]);
                    sum+=arr[i][j];
//                } else {
//                    System.out.print(" ");
                }
            }
//            System.out.println();
        }
        return sum;
    }
}
