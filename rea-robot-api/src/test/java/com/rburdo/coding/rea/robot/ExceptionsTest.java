package com.rburdo.coding.rea.robot;


import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExceptionsTest {

    @Test
    public void testRobotCommandParseException() {
        RobotCommandParseException exception = new RobotCommandParseException("test", "REPORT");
        assertThat(exception.getMessage(), is("test, command = REPORT"));
        assertThat(exception.getCommand(), is("REPORT"));

        exception = new RobotCommandParseException("test", "REPORT", new ParseException("blah", 2));
        assertThat(exception.getMessage(), is("test, command = REPORT"));
        assertThat(exception.getCommand(), is("REPORT"));
        assertThat(exception.getCause(), instanceOf(ParseException.class));
    }


    @Test
    public void testRobotNotOnBoardException() {
        RobotNotOnBoardException exception = new RobotNotOnBoardException();
        assertThat(exception.getMessage(), is("Robot has not been placed on board yet"));
    }
}
