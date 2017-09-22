package com.ek9v.coursera.greedy;

import com.ek9v.coursera.greedy.CoveringSegments.Segment;
import org.junit.Test;

import static com.ek9v.coursera.greedy.CoveringSegments.optimalPoints;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class CoveringSegmentsTest {

    @Test
    public void optimalPoints_sample1() throws Exception {
        Segment segment1 = new Segment(1, 3);
        Segment segment2 = new Segment(2, 5);
        Segment segment3 = new Segment(3, 6);

        Segment[] segments = new Segment[] {segment1, segment2, segment3};
        assertThat(optimalPoints(segments), is(new int[] {3}));
    }

    @Test
    public void optimalPoints_sample2() throws Exception {
        Segment segment1 = new Segment(4, 7);
        Segment segment2 = new Segment(1, 3);
        Segment segment3 = new Segment(2, 5);
        Segment segment4 = new Segment(5, 6);

        Segment[] segments = new Segment[] {segment1, segment2, segment3, segment4};
        assertThat(optimalPoints(segments), is(new int[] {3, 6}));
    }

    @Test
    public void optimalPoints_forOneSegment() throws Exception {
        Segment segment1 = new Segment(0, 1_000_000);

        Segment[] segments = new Segment[] {segment1};
        assertThat(optimalPoints(segments), is(new int[] {1_000_000}));
    }

    @Test
    public void optimalPoints_forManySegment() throws Exception {
        Segment[] segments = new Segment[100];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment(0, 1_000_000);
        }
        assertThat(optimalPoints(segments), is(new int[] {1_000_000}));
    }

    @Test
    public void optimalPoints_forZeroSegment() throws Exception {
        Segment segment1 = new Segment(0, 0);
        Segment segment2 = new Segment(0, 0);

        Segment[] segments = new Segment[] {segment1, segment2};
        assertThat(optimalPoints(segments), is(new int[] {0}));
    }

}