package com.rburdo.coding.rea.robot.impl.input;

import com.rburdo.coding.rea.robot.input.RobotCommandFactory;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputStreamRobotCommandFactory extends AbstractRobotCommandFactory implements RobotCommandFactory {
    private InputStream         inputStream;
    private boolean             commandsRead;
    private List<RobotCommand>  commands;


    public InputStreamRobotCommandFactory(InputStream inputStream, RobotCommandParser robotCommandParser) {
        super(robotCommandParser);
        this.inputStream = inputStream;
        this.commandsRead = false;
        this.commands = new ArrayList<>();
    }

    @Override
    public List<RobotCommand> getAllCommands() throws IOException {
        if (!commandsRead) {
            List<String> commandStrings = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                bufferedReader.lines().forEach((String s) -> commandStrings.add(s));
                commandsRead = true;
            }

            parseCommands(commandStrings, commands);
        }

        return commands;
    }

}
