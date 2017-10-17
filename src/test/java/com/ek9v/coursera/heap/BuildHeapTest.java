package com.ek9v.coursera.heap;

import com.ek9v.coursera.heap.BuildHeap.Swap;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 16.10.2017.
 */
public class BuildHeapTest {

    @Test
    public void buildOneElementHeap() throws Exception {
        BuildHeap heap = new BuildHeap();
        heap.setData(new int[] {1});
        assertThat(heap.buildHeap(), is(Matchers.empty()));
    }

    @Test
    public void generateSwapsFast_forUnsorted() throws Exception {
        BuildHeap heap = new BuildHeap();
        heap.setData(new int[] {5, 4, 3, 2, 1});

        List<Swap> swaps = heap.buildHeap();

        assertThat(swaps.size(), is(3));

        System.out.println(Arrays.toString(heap.getData()));
        List<Swap> expectedSwaps = new ArrayList<>();
        expectedSwaps.add(new Swap(1, 4));
        expectedSwaps.add(new Swap(0, 1));
        expectedSwaps.add(new Swap(1, 3));
        assertThat(swaps, is(expectedSwaps));

    }

    @Test
    public void generateSwapsFast_forSorted() throws Exception {
        BuildHeap heap = new BuildHeap();
        heap.setData(new int[] {1, 2, 3, 4, 5, 6});

        List<Swap> swaps = heap.buildHeap();

        assertThat(swaps.size(), is(0));

        System.out.println(Arrays.toString(heap.getData()));
    }

    @Test
    public void generateSwapsFast_forHugeSortedArr() throws Exception {
        int[] data = new int[100_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (i+1) * 10_000;
        }

        BuildHeap heap = new BuildHeap();
        heap.setData(data);
        List<Swap> swaps = heap.buildHeap();

        assertThat(swaps.size(), is(0));
    }

    @Test
    public void generateSwapsFast_forHugeUnsortedArr() throws Exception {
        int[] data = new int[100_000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (data.length - i) * 10_000;
        }

        BuildHeap heap = new BuildHeap();
        heap.setData(data);
        List<Swap> swaps = heap.buildHeap();

        assertThat(swaps.size(), is(99990));
    }

}