package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlaceCommandTest extends BaseCommandTest {

    @Test
    public void testPlaceCommand() throws Exception {
        PlaceCommand command = new PlaceCommand(0, 2, FacingDirection.SOUTH);
        command.setRobot(getRobot());
        command.execute();

        assertThat(getRobot().getLocation(), is(new Location(0, 2)));
        assertThat(getRobot().getFacingDirection(), is(FacingDirection.SOUTH));
    }
}
