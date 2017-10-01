package com.ek9v.coursera.divideConquer;

import com.ek9v.coursera.divideConquer.Closest.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by user on 28.09.2017.
 */
public class ClosestTest {

    @Test
    public void sort2DimensionArray() throws Exception {
        int[][] a = new int[3][2];
        a[0][0] = 3;
        a[0][1] = 0;
        a[1][0] = 1;
        a[1][1] = 1;
        a[2][0] = 2;
        a[2][1] = 2;
        Arrays.sort(a, (o1, o2) -> o1[0] == o2[0] ? 0 : o1[0] < o2[0] ? -1 : 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0] +"-"+ a[i][1]);
        }
    }

    @Test
    public void minimalDistance_forTwoPoints() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point[] points = {p1, p2};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(5, dist, 0.0001);
    }

    @Test
    public void minimalDistance_forFourPoints() throws Exception {
        Point p1 = new Point(5, 0);
        Point p2 = new Point(5, 3);
        Point p3 = new Point(2, 4);
        Point p4 = new Point(5, 5);
        Point[] points = {p1, p2, p3, p4};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(2, dist, 0.0001);
    }

    @Test
    public void minimalDistance_forOnePoint() throws Exception {
        Point p1 = new Point(0, 0);
        Point[] points = {p1};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(Double.POSITIVE_INFINITY, dist, 0.0001);
    }

    @Test
    public void minimalDistance_forAllPoints() throws Exception {
        Point[] points = new Point[100_000];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(-i * 10_000, i * 10_000);
        }

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(14142.1356, dist, 0.0001);
    }

    @Test
    public void minimalDistance_forHugePoints() throws Exception {
        Point p1 = new Point(-1_000_000_000, -1_000_000_000);
        Point p2 = new Point(1_000_000_000, 1_000_000_000);
        Point[] points = {p1, p2};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(2_828_427_124.7462, dist, 0.0001);
    }

    @Test
    public void minimalDistance_for4HugePoints() throws Exception {
        Point p1 = new Point(-1_000_000_000, -1_000_000_000);
        Point p2 = new Point(1_000_000_000, -1_000_000_000);
        Point p3 = new Point(-1_000_000_000, 1_000_000_000);
        Point p4 = new Point(1_000_000_000, 1_000_000_000);
        Point[] points = {p1, p2, p3, p4};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(2_000_000_000, dist, 0.0001);
    }

    @Test
    public void minimalDistance_for3Points() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(1, 1);
        Point[] points = {p1, p2, p3};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(1.4142, dist, 0.0001);
    }

    @Test
    public void minimalDistance_forEqualPoints() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(0, 0);
        Point[] points = {p1, p2, p3};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(0., dist, 0.0001);
    }

    @Test
    public void minimalDistance_forManyPoints() throws Exception {
        Point p1 = new Point(7, 7);
        Point p2 = new Point(1, 100);
        Point p3 = new Point(4, 8);
        Point p4 = new Point(7, 7);
        Point[] points = {p1, p2, p3, p4};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(0., dist, 0.0001);
    }

    @Test
    public void minimalDistance_forManyDiffPoints() throws Exception {
        Point p1 = new Point(4, 4);
        Point p2 = new Point(-2, -2);
        Point p3 = new Point(-3, -4);
        Point p4 = new Point(-1, 3);
        Point p5 = new Point(2, 3);
        Point p6 = new Point(-4, 0);
        Point p7 = new Point(1, 1);
        Point p8 = new Point(-1, -1);
        Point p9 = new Point(3, -1);
        Point p10 = new Point(-4, 2);
        Point p11 = new Point(-2, 4);
        Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};

        double dist = Closest.minimalDistance(points);
        Assert.assertEquals(1.4142, dist, 0.0001);
    }


}