package com.ek9v.algo.hackerrank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 15.12.2017.
 */
public class Array2DTest {

    @Test
    public void testPrintArray() throws Exception {
        int[][] arr =
                {
//                        {1, 1, 1, 0, 0, 0},
//                        {0, 1, 0, 0, 0, 0},
//                        {1, 1, 1, 0, 0, 0},
//                        {0, 0, 2, 4, 4, 0},
//                        {0, 0, 0, 2, 0, 0},
//                        {0, 0, 1, 2, 4, 0}
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 9, 2,-4,-4, 0},
                        {0, 0, 0,-2, 0, 0},
                        {0, 0,-1,-2,-4, 0},
                };

//        printArray(arr);
        assertThat(sumHourglass(arr, 0, 2, 0, 2), is(7));
//        assertThat(sumHourglass(arr, 1, 3, 0, 2), is(4));
//        assertThat(sumHourglass(arr, 3, 5, 0, 2), is(0));
//        assertThat(sumHourglass(arr, 0, 2, 1, 3), is(4));
//        assertThat(sumHourglass(arr, 3, 5, 3, 5), is(14));

        assertThat(maxSumHourglass(arr), is(13));
    }

    private int maxSumHourglass(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int h_row = 2, l_row = 0; h_row < arr.length; h_row++, l_row++)
            for (int h_col = 2, l_col = 0; h_col < arr.length; h_col++, l_col++) {
                int sum = sumHourglass(arr, l_col, h_col, l_row, h_row);
                maxSum = sum > maxSum ? sum : maxSum;
            }

        return maxSum;
    }

    private int sumHourglass(int[][] arr, int l_col, int h_col, int l_row, int h_row) {
        int sum = 0;
        for (int i = l_row; i <= h_row; i++) {
            for (int j = l_col; j <= h_col; j++) {
                if (i != (h_row + l_row)/2 || (j != l_col && j != h_col)) {
                    System.out.print(arr[i][j]);
                    sum+=arr[i][j];
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        return sum;
    }
}