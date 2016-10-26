package com.rburdo.coding.rea.robot.impl.input;

import com.rburdo.coding.rea.robot.impl.input.InputStreamRobotCommandFactory;
import com.rburdo.coding.rea.robot.impl.input.RobotCommandParser;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamRobotCommandFactoryFactory {
    private RobotCommandParser robotCommandParser;

    public InputStreamRobotCommandFactoryFactory(RobotCommandParser robotCommandParser) {
        this.robotCommandParser = robotCommandParser;
    }

    public InputStreamRobotCommandFactory create() throws IOException {
        return create(System.in);
    }

    public InputStreamRobotCommandFactory create(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("Commands input stream cannot be null");
        }
        return new InputStreamRobotCommandFactory(inputStream, robotCommandParser);
    }
}
