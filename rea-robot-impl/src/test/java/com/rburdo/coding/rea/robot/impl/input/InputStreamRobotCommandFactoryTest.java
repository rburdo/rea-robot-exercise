package com.rburdo.coding.rea.robot.impl.input;


import com.rburdo.coding.rea.robot.RobotCommandParseException;
import com.rburdo.coding.rea.robot.impl.input.command.MoveCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class InputStreamRobotCommandFactoryTest {
    private InputStream inputStream;

    @Mock
    private RobotCommandParser parser;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        inputStream = new ByteArrayInputStream("MOVE".getBytes());
        when(parser.parse("MOVE")).thenReturn(new MoveCommand());
    }

    @Test
    public void testSuccessful() throws Exception {
        InputStreamRobotCommandFactory factory = new InputStreamRobotCommandFactory(inputStream, parser);
        assertThat(factory.getAllCommands().size(), is(1));
        assertThat(factory.getAllCommands().get(0), instanceOf(MoveCommand.class));
    }

    @Test(expected = IOException.class)
    public void testConstructorThrowsIOException() throws Exception {
        inputStream = new FileInputStream("xyz");
        new InputStreamRobotCommandFactory(inputStream, parser);
    }

    @Test
    public void testCommandParsingFails() throws Exception {
        when(parser.parse(anyString())).thenThrow(new RobotCommandParseException("", ""));
        InputStreamRobotCommandFactory factory = new InputStreamRobotCommandFactory(inputStream, parser);
        assertThat(factory.getAllCommands().isEmpty(), is(true));
    }
}
