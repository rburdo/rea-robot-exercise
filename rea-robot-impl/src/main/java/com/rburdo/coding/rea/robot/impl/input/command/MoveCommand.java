package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.Location;
import com.rburdo.coding.rea.robot.RobotException;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;

public class MoveCommand extends BaseRobotCommand implements RobotCommand {

    @Override
    public void execute() throws RobotException {
        if (!verifyRobotOnBoard()) {
            return;
        }

        Integer currentLocation_x = getRobot().getLocation().getxLocation();
        Integer currentLocation_y = getRobot().getLocation().getyLocation();
        Location newLocation;

        switch(getRobot().getFacingDirection()) {
            case NORTH:
                newLocation = new Location(currentLocation_x, currentLocation_y + 1);
                break;

            case SOUTH:
                newLocation = new Location(currentLocation_x, currentLocation_y - 1);
                break;

            case EAST:
                newLocation = new Location(currentLocation_x + 1, currentLocation_y);
                break;

            case WEST:
                newLocation = new Location(currentLocation_x - 1, currentLocation_y);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unrecognized facing direction : " + getRobot().getFacingDirection());
        }

        getRobot().setLocation(newLocation);
    }

}
