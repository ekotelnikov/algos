package com.ek9v.coursera.heap;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 17.10.2017.
 */
public class JobQueueTest {

    @Test
    public void showJobs_when2Threads() throws Exception {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(2);
        jobQueue.setJobs(new int[] {1,2,3,4,5});
        jobQueue.assignJobsInQueue();

        assertThat(jobQueue.getAssignedWorker(), is(new int[] {0,1,0,1,0}));
        assertThat(jobQueue.getStartTime(), is(new long[] {0,0,1,2,4}));
    }

    @Test
    public void showJobs_whenThreadsMoreThenJobs() throws Exception {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(6);
        jobQueue.setJobs(new int[] {1,2,3,4,5});
        jobQueue.assignJobsInQueue();

        assertThat(jobQueue.getAssignedWorker(), is(new int[] {0,1,2,3,4}));
        assertThat(jobQueue.getStartTime(), is(new long[] {0,0,0,0,0}));
    }

    @Test
    public void show20Jobs_when4Threads() throws Exception {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(4);
        int[] jobs = new int[20];
        Arrays.fill(jobs, 1);

        jobQueue.setJobs(jobs);
        jobQueue.assignJobsInQueue();

        assertThat(jobQueue.getStartTime(), is(new long[] {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4}));
        assertThat(jobQueue.getAssignedWorker(), is(new int[] {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3}));
    }

    @Test
    public void showAllJobs_whenAllThreads() throws Exception {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(100_000);
        int[] jobs = new int[100_000];
        Arrays.fill(jobs, 1000_000_000);

        jobQueue.setJobs(jobs);
        jobQueue.assignJobsInQueue();

        long[] expectedStartTimes = new long[jobs.length];
        int[] expectedWorkers = new int[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            expectedWorkers[i] = i;
        }

        assertThat(jobQueue.getStartTime(), is(expectedStartTimes));
        assertThat(jobQueue.getAssignedWorker(), is(expectedWorkers));
    }
}