package com.rburdo.coding.rea.robot.impl.input;


import com.rburdo.coding.rea.robot.RobotCommandParseException;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public abstract class AbstractRobotCommandFactory {
    private Log logger = LogFactory.getLog(getClass());

    private RobotCommandParser robotCommandParser;

    protected AbstractRobotCommandFactory(RobotCommandParser robotCommandParser) {
        this.robotCommandParser = robotCommandParser;
    }

    protected RobotCommandParser getRobotCommandParser() {
        return robotCommandParser;
    }

    protected void parseCommands(List<String> commandStrings, List<RobotCommand> commands) {
        for (String commandString : commandStrings) {
            try {
                RobotCommand command = robotCommandParser.parse(commandString);
                if (command != null) {
                    commands.add(command);
                }
            } catch (RobotCommandParseException e) {
                logger.warn("Failed to parse command [" + e.getCommand() + "]", e);
            }
        }
    }
}
