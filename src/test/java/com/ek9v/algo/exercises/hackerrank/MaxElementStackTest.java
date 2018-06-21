package com.ek9v.algo.exercises.hackerrank;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;
import org.junit.Test;

/**
 * Created by user on 17.06.2018.
 */
public class MaxElementStackTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        MaxStackElement m = new MaxStackElement();
        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    int value = sc.nextInt();
                    m.push(value);
                    break;
                case 2:
                    m.pop();
                    break;
                case 3:
                    System.out.println(m.getMax());
                    break;
            }
        }
    }

    private final MaxStackElement maxStackElement = new MaxStackElement();

    @Test
    public void shouldPrintFirst_whenStackHasTwoDiff() throws Exception {
        maxStackElement.push(97);
        maxStackElement.pop();
        maxStackElement.push(20);
        maxStackElement.pop();
        maxStackElement.push(26);
        maxStackElement.push(20);
        assertThat(maxStackElement.getMax(), is(26));
    }
    @Test
    public void shouldReturnMax_whenElementWasPop() throws Exception {
        maxStackElement.push(3);
        maxStackElement.push(1);
        maxStackElement.push(2);
        maxStackElement.push(3);
        maxStackElement.pop();

        assertThat(maxStackElement.getMax(), is(3));
    }

    @Test
    public void shouldReturnMax_whenAllElementsAreEqual() throws Exception {
        maxStackElement.push(0);
        maxStackElement.push(0);
        maxStackElement.push(0);
        maxStackElement.push(0);
        maxStackElement.pop();

        assertThat(maxStackElement.getMax(), is(0));
    }
}