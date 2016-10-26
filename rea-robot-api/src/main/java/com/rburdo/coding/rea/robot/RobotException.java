package com.rburdo.coding.rea.robot;


public class RobotException extends Exception {
    public RobotException(String s) {
        super(s);
    }

    public RobotException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
