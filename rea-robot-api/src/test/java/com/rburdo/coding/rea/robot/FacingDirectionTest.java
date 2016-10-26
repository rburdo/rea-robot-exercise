package com.rburdo.coding.rea.robot;


import org.junit.Test;

import static com.rburdo.coding.rea.robot.FacingDirection.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FacingDirectionTest {

    @Test
    public void testRotateClockwise() {
        assertThat(NORTH.getNextClockwise(), is(EAST));
        assertThat(SOUTH.getNextClockwise(), is(WEST));
        assertThat(EAST.getNextClockwise(), is(SOUTH));
        assertThat(WEST.getNextClockwise(), is(NORTH));
    }

    @Test
    public void testRotateCounterClockwise() {
        assertThat(NORTH.getNextCounterClockwise(), is(WEST));
        assertThat(SOUTH.getNextCounterClockwise(), is(EAST));
        assertThat(EAST.getNextCounterClockwise(), is(NORTH));
        assertThat(WEST.getNextCounterClockwise(), is(SOUTH));
    }
}
