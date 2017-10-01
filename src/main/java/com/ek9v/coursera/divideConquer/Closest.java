package com.ek9v.coursera.divideConquer;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.x == x ? Long.signum(y - o.y) : Long.signum(x - o.x);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        return minimalDistance(points);
    }

    static double minimalDistance(Point[] points) {
        Point[] xPoints = new Point[points.length];
        List<Point> yPoints = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            xPoints[i] = points[i];
            yPoints.add(points[i]);
        }
        Arrays.sort(xPoints);
        yPoints.sort((p1, p2) -> p1.y == p2.y ? Long.signum(p1.x - p2.x) : Long.signum(p1.y - p2.y));
//        Arrays.sort(yPoints, (p1, p2) -> p1.y == p2.y ? Long.signum(p1.x - p2.x) : Long.signum(p1.y - p2.y));

        return minDistance(xPoints, yPoints, 0, points.length-1);
    }

    static double minDistance(Point[] xPoints, List<Point> yPoints, int lo, int hi) {
        if (lo == hi || yPoints.size() == 0) {
            return Double.POSITIVE_INFINITY;
        }
        int mid = lo + (hi - lo) / 2;
        Point midPoint = xPoints[mid];

        List<Point> left_y = new ArrayList<>();
        List<Point> right_y = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = lo; i <= hi; i++) {
            if (yPoints.get(i).x <= midPoint.x) {
                left_y.add(yPoints.get(i));
            } else {
                right_y.add(yPoints.get(i));
            }
        }

        double dist_left = minDistance(xPoints, left_y, lo, mid);
        double dist_right = minDistance(xPoints, right_y, mid+1, hi);
        double minDist = Double.min(dist_left, dist_right);

        List<Point> strip = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < yPoints.size(); i++) {
            if (Math.abs(yPoints.get(i).x - midPoint.x) < minDist) {
                strip.add(yPoints.get(i));
            }
        }
        return Double.min(minDist, stripClosest(strip, k, minDist));
    }

    static double minimalDistance(Point[] points, int lo, int hi) {
        if (lo == hi) {
            return Double.POSITIVE_INFINITY;
        }
        int mid = lo + (hi - lo) / 2;
        double dist1 = minimalDistance(points, lo, mid);
        double dist2 = minimalDistance(points, mid + 1, hi);
        double minDist = Double.min(dist1, dist2);

        long midX = points[mid].x;

        Point[] strip = new Point[points.length];
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= hi) {
            if (Math.abs(points[i].x - midX) < minDist) {
                if (Math.abs(points[j].x - midX) < minDist) {
                    if (points[i].y <= points[j].y) {
                        strip[k++] = points[i++];
                    } else {
                        strip[k++] = points[j++];
                    }
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }
        while (i <= mid) {
            if (Math.abs(points[i].x - midX) < minDist) {
                strip[k++] = points[i++];
            } else {
                i++;
            }
        }
        while (j <= hi) {
            if (Math.abs(points[j].x - midX) < minDist) {
                strip[k++] = points[j++];
            } else {
                j++;
            }
        }

//        double stripMin = stripClosest(strip, k, minDist);
//        minDist = Double.min(minDist, stripMin);

        return new BigDecimal(minDist).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static double stripClosest(List<Point> strip, int size, double minDist) {
        double min = minDist;

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size && (strip.get(j).y - strip.get(i).y < min); j++) {
                double dist = calcDistance(strip.get(i), strip.get(j));
                if (dist < min) {
                    min = dist;
                }
            }
        }

        return min;
    }

    private static double calcDistance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
