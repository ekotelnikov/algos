package com.ek9v.algo.exercises;

import java.util.Scanner;

/**
 * Created by user on 08.01.2017.
 */
public class Ex_1_4_18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		int[] intLine = new int[line.length()];
		for (int i = 0; i < line.length(); i++) {
			intLine[i] = Character.digit(line.charAt(i), 10);
		}

		LocalMin localMin = new LocalMin(intLine).invoke();
		int midIndex = localMin.getMidIndex();
		int min = localMin.getMin();

		System.out.println(String.format("local min in [%s] is %s", midIndex, min));
	}


}
