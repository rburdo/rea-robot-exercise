package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.input.command.RobotCommand;
import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;

public class PlaceCommand extends BaseRobotCommand implements RobotCommand {
    private Integer xLocation;
    private Integer yLocation;
    private FacingDirection facingDirection;

    public PlaceCommand(Integer xLocation, Integer yLocation, FacingDirection facingDirection) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.facingDirection = facingDirection;
    }

    @Override
    public void execute() {
        getRobot().setLocation(new Location(xLocation, yLocation));
        getRobot().setFacingDirection(facingDirection);
    }
}
