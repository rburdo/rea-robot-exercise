package com.rburdo.coding.rea.robot;


public class RobotNotOnBoardException extends RobotException {
    public RobotNotOnBoardException() {
        super("Robot has not been placed on board yet");
    }
}
