package com.ek9v.algo.lafore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 04.06.2017.
 */
public class PostfixCalcTest {

    @Test
    public void calculate() throws Exception {
        PostfixCalc postfixCalc = new PostfixCalc("412+3+*");
        
        assertThat(postfixCalc.calculate(), is(24));
    }

    @Test
    public void calculateDbl() throws Exception {
        PostfixCalc postfixCalc = new PostfixCalc("4.5;1;2;+3;+*");

        assertThat(postfixCalc.calculate(), is(27));
    }

}