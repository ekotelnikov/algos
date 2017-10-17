package com.ek9v.coursera.heap;

import java.io.*;
import java.util.*;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public List<Swap> getSwaps() {
        return swaps;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    List<Swap> buildHeap() {
        swaps = new ArrayList<>();

        int mid = data.length / 2;
        for (int i = mid; i >= 0; i--) {
            siftDown(i);
        }

        return swaps;
    }

    private void siftDown(int i) {
        int minIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < data.length && data[left] < data[minIndex]) {
            minIndex = left;
        }
        if (right < data.length && data[right] < data[minIndex]) {
            minIndex = right;
        }
        if (i != minIndex) {
            swapElements(i, minIndex);
            siftDown(minIndex);
        }
    }

    private void swapElements(int i, int j) {
        swaps.add(new Swap(i, j));
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    List<Swap> generateSwaps() {
      swaps = new ArrayList<Swap>();
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
      for (int i = 0; i < data.length; ++i) {
        for (int j = i + 1; j < data.length; ++j) {
          if (data[i] > data[j]) {
            swaps.add(new Swap(i, j));
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
          }
        }
      }

      return swaps;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        buildHeap();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public String toString() {
            return "{" + index1 + ", " + index2 + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Swap swap = (Swap) o;
            return index1 == swap.index1 &&
                    index2 == swap.index2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index1, index2);
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
