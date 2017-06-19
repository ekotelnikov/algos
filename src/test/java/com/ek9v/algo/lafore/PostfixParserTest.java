package com.ek9v.algo.lafore;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Test for {@link PostfixParser}.
 */
public class PostfixParserTest {

    @Test
    public void parsePlusAndMinus() throws Exception {
        PostfixParser parser = new PostfixParser("1+2-3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12+3-"));
    }

    @Test
    public void parseMultAndMinus() throws Exception {
        PostfixParser parser = new PostfixParser("1*2-3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12*3-"));
    }

    @Test
    public void parsePlusAndMult() throws Exception {
        PostfixParser parser = new PostfixParser("1+2*3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("123*+"));
    }

    @Test
    public void parseBktPlusAndMult() throws Exception {
        PostfixParser parser = new PostfixParser("(1+2+3)*4");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12+3+4*"));
    }

    @Test
    public void parseMultAndBktPlus() throws Exception {
        PostfixParser parser = new PostfixParser("4*(1+2+3)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("412+3+*"));
    }
    @Ignore
    @Test
    public void parseDoublMultAndBktPlus() throws Exception {
        PostfixParser parser = new PostfixParser("4.5*(1+2+3)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("4.5;1;2;+3;+*"));
    }

    @Test
    public void parsePlusMultBktMinus() throws Exception {
        PostfixParser parser = new PostfixParser("A+B*(C-D)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("ABCD-*+"));
    }
}