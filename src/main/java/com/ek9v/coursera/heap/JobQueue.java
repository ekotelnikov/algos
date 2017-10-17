package com.ek9v.coursera.heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public void setNumWorkers(int numWorkers) {
        this.numWorkers = numWorkers;
    }

    public void setJobs(int[] jobs) {
        this.jobs = jobs;
    }

    public int[] getAssignedWorker() {
        return assignedWorker;
    }

    public long[] getStartTime() {
        return startTime;
    }

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    void assignJobsInQueue() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        PriorityQueue<WorkerAndTime> q = createWorkerQueue();

        for (int i = 0; i < jobs.length; i++) {
            WorkerAndTime wj = q.poll();
            assignedWorker[i] = wj.w;
            startTime[i] = wj.time;

            q.add(new WorkerAndTime(wj.w, wj.time + jobs[i]));
        }

    }

    private PriorityQueue<WorkerAndTime> createWorkerQueue() {
        Comparator<WorkerAndTime> c =
                (o1, o2) -> {
                    int r = Long.compare(o1.time, o2.time);
                    if (r != 0) {
                        return r;
                    }
                    return Integer.compare(o1.w, o2.w);
                };
        PriorityQueue<WorkerAndTime> q = new PriorityQueue<>(numWorkers, c);
        for (int i = 0; i < numWorkers; i++) {
            q.add(new WorkerAndTime(i, 0));
        }
        return q;
    }

    void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker[i] = bestWorker;
            startTime[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobsInQueue();
        writeResponse();
        out.close();
    }

    static class WorkerAndTime {
        private int w;
        private long time;

        public WorkerAndTime(int w, long time) {
            this.w = w;
            this.time = time;
        }

        @Override
        public String toString() {
            return "{" + w + "," + time + '}';
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
