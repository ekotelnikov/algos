package com.ek9v.algo.exercises.sort;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.PI;

/**
 * Created by user on 28.01.2017.
 */
public class InsertionSort {

    private static final int scaleY = 10;
    private static final int scaleX = 10;

    private static double unitY = 1.;
    private static double unitX = 1.;

    public static void main(String[] args) {
        System.out.println("Enter the array size:");

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        int max_y = Integer.MIN_VALUE;
        Random rnd = new Random();
        for(int i=0;i<s;i++){
//            ar[i]=in.nextInt();
            ar[i] = Double.valueOf(rnd.nextDouble() * 100).intValue();
            if (ar[i] > max_y) {
                max_y = ar[i];
            }
        }
        unitY = (double) scaleY / max_y;
        unitX = (double) scaleX / s;
        System.out.println("unit X:" + unitX);
        System.out.println("half width:" + unitX * 0.25);

        StdDraw.setYscale(0, scaleY + 1);
        StdDraw.setXscale(-0.5, scaleX + 1);
        StdDraw.enableDoubleBuffering();

        StdDraw.pause(2000);
        printArray(ar);
        insertionSortPart2(ar);
    }

    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            for (int j = i; j > 0 && ar[j-1] > ar[j]; j--) {
                int tmp = ar[j-1];
                ar[j-1] = ar[j];
                ar[j] = tmp;
                printArray(ar);
            }
        }
    }

    private static void printArray(int[] ar) {
        StdDraw.clear();
        for (int i = 0; i < ar.length; i++) {
            double y = (ar[i] * unitY) + 0.2;
            double x = i * unitX;
            StdDraw.filledRectangle(x, y / 2., 0.4 * unitX, y / 2.);
        }
        StdDraw.show();
        StdDraw.pause(100);
    }
}
