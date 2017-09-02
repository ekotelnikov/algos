package com.ek9v.algo.lafore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 19.07.2017.
 */
public class PostfixTest {

    @Test(expected = EmptyInputException.class)
    public void whenPostfixHasEmptyInput_throwEmptyInput() throws Exception {
        Postfix postfix = new Postfix("");
        postfix.calculate();
    }

    @Test
    public void whenCalculate2plus2_return4() throws Exception {
        Postfix p = new Postfix("2+2");
        int r = p.calculate();
        assertThat(r, is(4));
    }

    @Test
    public void whenCalculate3minus1_return2() throws Exception {
        Postfix p = new Postfix("3-1");
        int r = p.calculate();

        assertThat(r, is(2));
    }
}
