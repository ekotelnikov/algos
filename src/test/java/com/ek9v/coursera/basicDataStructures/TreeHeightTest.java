package com.ek9v.coursera.basicDataStructures;

import com.ek9v.coursera.basicDataStructures.TreeHeightCalc.TreeHeight;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 10.10.2017.
 */
public class TreeHeightTest {

    @Test
    public void computeHeightBrutForce() throws Exception {
        TreeHeight tree = new TreeHeight();
        tree.n = 10;
        tree.parent = new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 3};
        int h = tree.computeHeightBrutForce();

        assertEquals(4, h);
    }

    @Test
    public void computeHeightFast_forOneElementTree() throws Exception {
        TreeHeight tree = new TreeHeight();
        tree.n = 1;
        tree.parent = new int[]{-1};
        tree.readAsNodes();
        int h = tree.computeHeightFast();

        assertEquals(1, h);
    }

    @Test
    public void computeHeightFast() throws Exception {
        TreeHeight tree = new TreeHeight();
        tree.n = 10;
        tree.parent = new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 3};
        tree.readAsNodes();
        int h = tree.computeHeightFast();

        assertEquals(4, h);
    }

    @Test
    public void computeHeightFast_forOneLineTree() throws Exception {
        TreeHeight tree = new TreeHeight();
        tree.n = 10;
        tree.parent = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        tree.readAsNodes();
        int h = tree.computeHeightFast();

        assertEquals(10, h);
    }
}