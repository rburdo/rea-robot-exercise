package com.rburdo.coding.rea.robot.input.command;


import com.rburdo.coding.rea.robot.RobotException;

public interface RobotCommand {

    void execute() throws RobotException;

}
