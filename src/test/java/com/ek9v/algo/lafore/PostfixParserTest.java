package com.ek9v.algo.lafore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 19.07.2017.
 */
public class PostfixParserTest {

    @Test
    public void parse2plus2_return22plus() throws Exception {
        PostfixParser parser = new PostfixParser();
        String postfixExp = parser.parse("2+2");
        assertThat(postfixExp, is("22+"));
    }

    @Test
    public void parse2minus1_return21minus() throws Exception {
        PostfixParser parser = new PostfixParser();
        String postfixExp = parser.parse("2-1");
        assertThat(postfixExp, is("21-"));
    }

    @Test
    public void parse3plus1minus2_return31plus2minus() throws Exception {
        PostfixParser parser = new PostfixParser();
        String postfixExp = parser.parse("3+1-2");
        assertThat(postfixExp, is("31+2-"));
    }
}