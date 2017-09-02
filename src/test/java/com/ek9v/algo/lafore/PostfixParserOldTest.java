package com.ek9v.algo.lafore;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Test for {@link PostfixParser}.
 */
public class PostfixParserOldTest {

    @Test
    public void parsePlusAndMinus() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("1+2-3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12+3-"));
    }

    @Test
    public void parseMultAndMinus() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("1*2-3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12*3-"));
    }

    @Test
    public void parsePlusAndMult() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("1+2*3");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("123*+"));
    }

    @Test
    public void parseBktPlusAndMult() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("(1+2+3)*4");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("12+3+4*"));
    }

    @Test
    public void parseMultAndBktPlus() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("4*(1+2+3)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("412+3+*"));
    }
    @Ignore
    @Test
    public void parseDoublMultAndBktPlus() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("4.5*(1+2+3)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("4.5;1;2;+3;+*"));
    }

    @Test
    public void parsePlusMultBktMinus() throws Exception {
        PostfixParserOld parser = new PostfixParserOld("A+B*(C-D)");
        String parsedExp = parser.parse();

        assertThat(parsedExp, is("ABCD-*+"));
    }
}