package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.Location;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BoardTest {

    @Test
    public void testSuccessfulConstructor() {
        new Board(0, 3, 0, 5);
        new Board(-2, 3, -8, 5);
        new Board(3, 3, -8, 5);
        new Board(3, 3, -8, -8);
    }

    @Test
    public void testFailedConstructor() {
        int illegalParameterGroups[][] = {
                { 3, 2, 1, 7},
                { 3, 2, 7, 1},
                { 2, 3, 7, 1}
        };
        for (int[] illegalParameters : illegalParameterGroups) {
            try {
                new Board(illegalParameters[0], illegalParameters[1], illegalParameters[2], illegalParameters[3]);
                fail("Should not get here!");
            } catch (IllegalArgumentException e) {
                // OK
            }
        }
    }

    @Test
    public void testInValid() {
        Board board = new Board(0, 5, 0, 5);
        assertLocation(board, 1, 2, true);
        assertLocation(board, 0, 0, true);
        assertLocation(board, 5, 5, true);
        assertLocation(board, 0, 5, true);
        assertLocation(board, 5, 0, true);
        assertLocation(board, 0, 6, false);
        assertLocation(board, 6, 0, false);
        assertLocation(board, -1, 0, false);
        assertLocation(board, 0, -1, false);

    }

    private void assertLocation(Board board, int x, int y, boolean expected) {
        assertThat(board.isValid(new Location(x, y)), is(expected));
    }
}
