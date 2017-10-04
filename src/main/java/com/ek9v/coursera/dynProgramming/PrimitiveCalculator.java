package com.ek9v.coursera.dynProgramming;

import java.util.*;

public class PrimitiveCalculator {

    static List<Integer> optimalSequence(int n) {
        List<Integer> hash = new ArrayList<>();
        hash.add(0, -1);
        int op = 0;
        for (int i = 1; i <= n; i++) {
            optSequence(i, hash);
        }
        List<Integer> seq = new ArrayList<>();
        calcSeq(n, hash, seq);

        Collections.reverse(seq);
        return seq;
    }

    private static void calcSeq(int n, List<Integer> hash, List<Integer> seq) {
        seq.add(n);
        if (n == 1) {
            return;
        }
        int op1 = hash.get(n-1);
        int op2 = Integer.MAX_VALUE;
        int op3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            op2 = hash.get(n/2);
        }
        if (n % 3 == 0) {
            op3 = hash.get(n/3);
        }
        if (Integer.min(op1, Integer.min(op2, op3)) == op1) {
            calcSeq(n-1, hash, seq);
        } else if (Integer.min(op1, Integer.min(op2, op3)) == op2) {
            calcSeq(n/2, hash, seq);
        } else if (Integer.min(op1, Integer.min(op2, op3)) == op3) {
            calcSeq(n/3, hash, seq);
        }
    }

    private static int optSequence(int n, List<Integer> hash) {
        if (n < hash.size()) {
            return hash.get(n);
        }

        if (n == 1) {
            hash.add(1, 0);
            return 0;
        }

        int minOp = Integer.MAX_VALUE;
        int op1 = optSequence(n - 1, hash);
        if (op1 < minOp) {
            minOp = op1;
        }
        if (n % 3 == 0) {
            int op3 = optSequence(n/3, hash);
            if (op3 < minOp) {
                minOp = op3;
            }
        }
        if (n % 2 == 0) {
            int op2 = optSequence(n/2, hash);
            if (op2 < minOp) {
                minOp = op2;
            }
        }
        hash.add(n, minOp + 1);

        return minOp;
    }

    static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

