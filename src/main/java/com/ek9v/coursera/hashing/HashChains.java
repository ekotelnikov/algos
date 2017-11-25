package com.ek9v.coursera.hashing;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // for hash function
    private int bucketCount;
    private List<LinkedList<String>> buckets;

    private int prime = 1000000007;
    private int multiplier = 263;

    public void setBucketCount(int bucketCount) {
        this.bucketCount = bucketCount;
    }

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                add(query.s);
                break;
            case "del":
                delete(query.s);
                break;
            case "find":
                writeSearchResult(find(query.s));
                break;
            case "check":
                out.println(check(query.ind));
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        initializeHashTable();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    void initializeHashTable() {
        buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(String string) {
        int hash = hashFunc(string);
        LinkedList<String> chain = buckets.get(hash);
        if (chain == null) {
            chain = new LinkedList<>();
        }
        if (!chain.contains(string)) {
            chain.push(string);
        }
    }

    public String check(int i) {
        if (i >= buckets.size()) {
            return "";
        }
        return buckets.get(i).stream().collect(Collectors.joining(" "));
    }

    public void delete(String string) {
        int hash = hashFunc(string);
        buckets.get(hash).removeFirstOccurrence(string);
    }

    public boolean find(String string) {
        int hash = hashFunc(string);
        return buckets.get(hash).contains(string);
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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
