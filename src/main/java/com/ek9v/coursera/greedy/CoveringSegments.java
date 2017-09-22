package com.ek9v.coursera.greedy;

import java.util.*;

public class CoveringSegments {

    static int[] optimalPoints(Segment[] segments) {
        List<Integer> points = new ArrayList<>();
        int i = 0;
        Arrays.sort(segments);
        while (i < segments.length) {
            int r = minEnd(segments, i);
            points.add(r);
            i++;
            while (i < segments.length && segments[i].start <= r) {
                i++;
            }
        }
        return points.stream().mapToInt(v -> v).toArray();
    }

    private static int minEnd(Segment[] segments, int i) {
        int min = Integer.MAX_VALUE;
        for (int j = i; j < segments.length; j++) {
            if (segments[j].end < min) {
                min = segments[j].end;
            }
        }
        return min;
    }

    static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment s) {
            return this.start < s.start ? -1 : this.start == s.start ? 0 : 1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
