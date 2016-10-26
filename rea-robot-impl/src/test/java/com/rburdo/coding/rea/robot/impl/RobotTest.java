package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class RobotTest {
    @Mock
    private Board board;

    private Robot robot;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(board.isValid(any(Location.class))).thenReturn(true);
        robot = new Robot(board);
    }

    @Test
    public void testAccessors() {
        robot.setLocation(new Location(2, 3));
        robot.setFacingDirection(FacingDirection.NORTH);
        assertThat(robot.getLocation(), is(new Location(2, 3)));
        assertThat(robot.getFacingDirection(), is(FacingDirection.NORTH));
    }


    @Test
    public void testSetlocationValidity() {
        robot.setLocation(new Location(2, 3));
        when(board.isValid(any(Location.class))).thenReturn(false);
        robot.setLocation(new Location(1, 4));
        assertThat(robot.getLocation(), is(new Location(2, 3)));
    }

}
