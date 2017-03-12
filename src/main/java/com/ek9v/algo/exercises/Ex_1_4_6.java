package com.ek9v.algo.exercises;

/**
 * Created by user on 07.01.2017.
 */
public class Ex_1_4_6 {

	public static void main(String[] args) {
		for (int i = 1000; i < 128000; i *= 2) {
			long startTime = System.nanoTime();
			int count = doubleNLogN(i);
			long time = System.nanoTime() - startTime;
			System.out.println(time + ":" + count);
		}
	}

	private static int doubleNLogN(int N) {
		int count = 0;
		int log = 0;
		for (int n = N; n > 0; n /= 2) {
			for (int i = 0; i < n; i++) {
				count++;
			}
			log++;
		}
		System.out.println(log);
		return count;
	}

	private static int nLogN(int N) {
		int count = 0;
		int log = 0;
		for (int i = 1; i < N; i *= 2) {
			for (int j = 0; j < N; j++) {
				count++;
			}
			log++;
		}
//		System.out.println(log);
		return count;
	}
}
