package com.rburdo.coding.rea.robot;


public class RobotCommandParseException extends RobotException {
    private String command;

    public RobotCommandParseException(String message, String command) {
        super(message + ", command = " + command);
        this.command = command;
    }

    public RobotCommandParseException(String message, String command, Throwable th) {
        super(message + ", command = " + command, th);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
