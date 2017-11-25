package com.ek9v.coursera.hashing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    public static final int P = 1007;
    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        Data data = readInput();
        printOccurrences(getOccurrencesFast(data.text, data.pattern));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    static List<Integer> getOccurrences(String s, String t) {
        int m = s.length(), n = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        for (int i = 0; i + m <= n; ++i) {
	    boolean equal = true;
	    for (int j = 0; j < m; ++j) {
		if (s.charAt(j) != t.charAt(i + j)) {
		     equal = false;
 		    break;
		}
	    }
            if (equal)
                occurrences.add(i);
	}
        return occurrences;
    }

    static List<Integer> getOccurrencesFast(String text, String pattern) {
        int t = text.length();
        int p = pattern.length();
        long[] hashes = computeHashes(text, t, p);

        List<Integer> occur = new ArrayList<>();
        long pHash = hashCode(pattern);
        for (int i = 0; i <= t - p; i++) {
            if (pHash == hashes[i] && pattern.equals(text.substring(i, i + p))) {
                occur.add(i);
            }
        }

        return occur;
    }

    public static long hashCode(String value) {
        long h = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            h = ((31 * h) + value.charAt(i)) % P;
        }
        return h;
    }

    private static long[] computeHashes(String text, int t, int p) {
        long[] hashes = new long[t-p+1];
        long hash_tp = hashCode(text.substring(t - p, t));
        hashes[t-p] = hash_tp;
        long y = 1;
        //prime number from java.lang.String hashCode()
        int x = 31;
        for (int i = 1; i <= p ; i++) {
            y = (y * x) % P;
        }
        for (int i = t - p - 1; i >= 0; i--) {
            hashes[i] = ((hashes[i+1] * x - text.charAt(i+p) * y + text.charAt(i)) % P + P) % P;
        }
        return hashes;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
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

