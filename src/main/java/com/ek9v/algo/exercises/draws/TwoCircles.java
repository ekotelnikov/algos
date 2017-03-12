package com.ek9v.algo.exercises.draws;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

import static java.lang.Math.PI;

/**
 * Created by user on 28.01.2017.
 */
public class TwoCircles {

    public static void main(String[] args) {
        circle();
    }

    public static void circle() {
        StdDraw.setScale(-2, +2);
        StdDraw.enableDoubleBuffering();
        int count = 0;

        for (double t = 0.0; true; t += 0.02) {
            double x = Math.sin(t);
            double y = Math.cos(t);
            count = (int) (t / (2 * PI));

            StdDraw.clear();

            StdDraw.setPenColor(Color.red);
            StdDraw.filledCircle(0, 0, 0.1);

            StdDraw.setPenColor(Color.blue);
            StdDraw.filledCircle(x, y, 0.05);

            StdDraw.setPenColor(Color.black);
            double xM = x + 0.2*Math.sin(2*t);
            double yM = y + 0.2*Math.cos(2*t);
//            StdDraw.point(xM, yM);
            StdDraw.filledCircle(xM, yM, 0.025);


            StdDraw.setPenColor(Color.black);
            StdDraw.textLeft(-1.2, 0, String.valueOf(count));

            StdDraw.show();
            StdDraw.pause(20);
        }
    }

}
