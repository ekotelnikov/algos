package com.ek9v.coursera.divideConquer;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        int minPoint = getMin(points);
        int maxPoint = getMax(points);
        int minS = getMin(starts);
        int maxE = getMax(ends);

        if (maxPoint < minS || minPoint > maxE) {
            return cnt;
        }

        Segment[] segments = new Segment[starts.length];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment(starts[i], ends[i]);
        }
        Arrays.sort(segments);

        for (int i = 0; i < points.length; i++) {
            Segment pSegment = new Segment(points[i], points[i]);
            int p_i = Arrays.binarySearch(segments, pSegment);
            if (p_i >=0) {
                while (p_i < points.length && segments[p_i].start == points[i]) {
                    p_i++;
                }
            }

            if (p_i == -1) {
                cnt[i] = 0;
            } else if (p_i == 0) {
                cnt[i] = 1;
            } else {
                p_i = p_i < 0 ? -(p_i + 1) : p_i;

                int ends_i = 0;
                for (int j = 0; j < p_i; j++) {
                    Segment s = segments[j];
                    if (s.end >= points[i]) {
                        ends_i++;
                    }
                }
                cnt[i] = ends_i;
            }
        }
        return cnt;
    }

    static int[] fastCountSegments2(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        Segment[] segments = new Segment[starts.length];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment(starts[i], ends[i]);
        }
        Arrays.sort(segments);

        int minPoint = getMin(points);
        int maxPoint = getMax(points);

        if (maxPoint < segments[0].start || minPoint > segments[segments.length - 1].end) {
            return cnt;
        }
        for (int i = 0; i < points.length; i++) {
            int count_i = countPoints(segments, points[i]);
            cnt[i] = count_i;
        }

        return cnt;
    }

    private static int countPoints(Segment[] segments, int point) {
        Segment pSegment = new Segment(point, point);
        int startIndex = Arrays.binarySearch(segments, pSegment);
        int startCount = startIndex < 0 ? -(startIndex + 1) : startIndex + 1;
        if (startCount == 0) {
            return 0;
        }

        Segment[] subSegments = Arrays.copyOfRange(segments, 0, startCount);
        Arrays.sort(subSegments, PointsAndSegments::compareEnds);

        int endIndex = Arrays.binarySearch(subSegments, pSegment);
        int endCount = endIndex < 0 ? -(endIndex + 1) : endIndex + 1;

        return startCount - endCount;
    }

    private static int compareEnds(Segment s1, Segment s2) {
        return s1.end < s2.end ? -1 : s1.end > s2.end ? 1 : 0;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int a : arr) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment s) {
            return this.start < s.start ? -1 : this.start == s.start ? 0 : 1;
        }

        @Override
        public String toString() {
            return "Segment{" + start + ", " + end + '}';
        }
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

