package com.ek9v.coursera.dynProgramming;

import java.util.*;

class EditDistance {

  static int editDistance(String s, String t) {
    int[][] d = new int[s.length()+1][t.length()+1];

    for (int j = 1; j <= t.length(); j++) {
      d[0][j] = j;
      for (int i = 1; i <= s.length(); i++) {
        d[i][0] = i;
        int ins = d[i][j-1] + 1;
        int del = d[i-1][j] + 1;
        int match = d[i-1][j-1];
        int mismatch = d[i-1][j-1] + 1;
        if (s.toCharArray()[i-1] == t.toCharArray()[j-1]) {
          d[i][j] = Integer.min(Integer.min(ins, del), match);
        } else {
          d[i][j] = Integer.min(Integer.min(ins, del), mismatch);
        }
      }
    }

    return d[s.length()][t.length()];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
  }

}
