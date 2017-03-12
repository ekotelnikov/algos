package com.ek9v.algo.exercises;

/**
 * Created by user on 16.01.2017.
 */
public class CamelCase {

	public static int countWords(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				count++;
			}
		}
		return count;
	}
}
