package com.ek9v.algo.exercises;

/**
 * Created by user on 08.01.2017.
 */
public class LocalMin {

	private int[] intLine;
	private int midIndex;
	private int min;
	private int count;

	public LocalMin(int... intLine) {
		this.intLine = intLine;
	}

	public int getMidIndex() {
		return midIndex;
	}

	public int getMin() {
		return min;
	}

	public int getCount() {
		return count;
	}

	public LocalMin invoke() {
		int hi = intLine.length - 1;
		int lo = 0;
		while (lo <= hi) {
			count++;
			midIndex = lo + (hi - lo) / 2;
			min = intLine[midIndex];
			if (midIndex == 0 || midIndex == intLine.length - 1) {
				break;
			} else if (min > intLine[midIndex - 1]) {
				hi = midIndex - 1;
			} else if (min > intLine[midIndex + 1]) {
				lo = midIndex + 1;
			} else {
				break;
			}
		}
		return this;
	}
}
