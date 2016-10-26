package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LeftCommandTest extends BaseCommandTest {

    @Test
    public void testLeftCommand() throws Exception {
        LeftCommand command = new LeftCommand();
        command.setRobot(getRobot());
        getRobot().setLocation(new Location(1, 1));
        getRobot().setFacingDirection(FacingDirection.WEST);

        FacingDirection facingDirection = getRobot().getFacingDirection();
        for (int i = 0; i < 10; i++) {
            command.execute();
            assertThat(getRobot().getFacingDirection(), is(facingDirection.getNextCounterClockwise()));
            facingDirection = getRobot().getFacingDirection();
        }
    }

}
