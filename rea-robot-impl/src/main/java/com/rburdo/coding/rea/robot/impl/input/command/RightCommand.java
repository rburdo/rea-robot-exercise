package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.RobotException;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;

public class RightCommand extends BaseRobotCommand implements RobotCommand {

    @Override
    public void execute() throws RobotException {
        if (verifyRobotOnBoard()) {
            getRobot().setFacingDirection(getRobot().getFacingDirection().getNextClockwise());
        }
    }

}
