package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MoveCommandTest extends BaseCommandTest {

    @Test
    public void testMoveCommand() throws Exception {
        MoveCommand command = new MoveCommand();
        command.setRobot(getRobot());
        getRobot().setLocation(new Location(getBoard().getMinX(), getBoard().getMinY()));
        getRobot().setFacingDirection(FacingDirection.EAST);

        for (int i = getBoard().getMinX(); i < getBoard().getMaxX(); i++) {
            command.execute();
            assertThat(getRobot().getLocation(), is(new Location(i + 1, getBoard().getMinY())));
        }
        command.execute();
        assertThat(getRobot().getLocation(), is(new Location(getBoard().getMaxX(), getBoard().getMinY())));

        getRobot().setFacingDirection(FacingDirection.NORTH);
        for (int i = getBoard().getMinY(); i < getBoard().getMaxY(); i++) {
            command.execute();
            assertThat(getRobot().getLocation(), is(new Location(getBoard().getMaxX(), i + 1)));
        }
        command.execute();
        assertThat(getRobot().getLocation(), is(new Location(getBoard().getMaxX(), getBoard().getMaxY())));

        getRobot().setFacingDirection(FacingDirection.WEST);
        for (int i = getBoard().getMaxX(); i > getBoard().getMinX(); i--) {
            command.execute();
            assertThat(getRobot().getLocation(), is(new Location(i - 1, getBoard().getMaxY())));
        }
        command.execute();
        assertThat(getRobot().getLocation(), is(new Location(getBoard().getMinX(), getBoard().getMaxY())));

        getRobot().setFacingDirection(FacingDirection.SOUTH);
        for (int i = getBoard().getMaxY(); i > getBoard().getMinY(); i--) {
            command.execute();
            assertThat(getRobot().getLocation(), is(new Location(getBoard().getMinX(), i - 1)));
        }
        command.execute();
        assertThat(getRobot().getLocation(), is(new Location(getBoard().getMinX(), getBoard().getMinY())));
    }

}
