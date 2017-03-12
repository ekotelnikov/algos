package com.ek9v.algo.exercises;

/**
 * Hackerrank Encryption.
 */
public class Encryption {

	public static String encrypt(String s) {
		if (s == null || s.length() == 0) return "";

		int n = s.length();
		Double r = Math.sqrt((double) n);
		int row = (int) Math.floor(r);
		int col = (int) Math.ceil(r);
		if (col * row < n) {
			row++;
		}

		char[][] chars = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int index = i * col + j;
				if (index < s.length()) {
					chars[i][j] = s.charAt(index);
				}
			}
		}
		StringBuilder sb = new StringBuilder(n);
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row; i++) {
				if (chars[i][j] != 0) {
					sb.append(chars[i][j]);
				}
			}
			sb.append(" ");
		}

		return sb.toString().trim();
	}
}
