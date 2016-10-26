package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.RobotNotOnBoardException;
import com.rburdo.coding.rea.robot.impl.Robot;

public abstract class BaseRobotCommand {
    private Robot robot;

    protected boolean verifyRobotOnBoard() throws RobotNotOnBoardException {
        return robot.getLocation() != null && robot.getFacingDirection() != null;
    }

    protected Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
