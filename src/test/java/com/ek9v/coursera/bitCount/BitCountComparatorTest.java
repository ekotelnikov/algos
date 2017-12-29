package com.ek9v.coursera.bitCount;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by user on 09.12.2017.
 */
public class BitCountComparatorTest {

    static int[] rearrange(int[] elements) {
        List<Integer> ints = Arrays.stream(elements).boxed().collect(Collectors.toList());
        Collections.sort(ints, (o1, o2) -> Integer.bitCount(o1) > Integer.bitCount(o2) ? 1 :
                Integer.bitCount(o1) == Integer.bitCount(o2) ? o1.compareTo(o2) : -1);
        return ints.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testRearrange() throws Exception {
        int[] actual = rearrange(new int[] {5, 3, 7 , 10, 14});

        assertArrayEquals(new int[] {3, 5, 10, 7, 14}, actual);

    }
}