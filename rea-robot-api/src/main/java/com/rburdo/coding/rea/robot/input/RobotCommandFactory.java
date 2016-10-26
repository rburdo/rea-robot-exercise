package com.rburdo.coding.rea.robot.input;


import com.rburdo.coding.rea.robot.input.command.RobotCommand;

import java.io.IOException;
import java.util.List;

public interface RobotCommandFactory {

    List<RobotCommand> getAllCommands() throws IOException;

}
