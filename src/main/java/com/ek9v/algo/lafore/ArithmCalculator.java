package com.ek9v.algo.lafore;

import java.util.Scanner;

/**
 * Calculator of arithmetical expression.
 */
public class ArithmCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        PostfixParser parser = new PostfixParser(exp);
        String parsedExp = parser.parse();
        PostfixCalc postfixCalc = new PostfixCalc(parsedExp);
        int result = postfixCalc.calculate();
        System.out.println(result);
    }

}
