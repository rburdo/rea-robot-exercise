package com.rburdo.coding.rea.robot.impl.input;

import com.rburdo.coding.rea.robot.RobotCommandParseException;
import com.rburdo.coding.rea.robot.impl.input.command.LeftCommand;
import com.rburdo.coding.rea.robot.impl.input.command.MoveCommand;
import com.rburdo.coding.rea.robot.impl.input.command.PlaceCommand;
import com.rburdo.coding.rea.robot.impl.input.command.ReportCommand;
import com.rburdo.coding.rea.robot.impl.input.command.RightCommand;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class RobotCommandParserTest {
    private RobotCommandParser parser = new RobotCommandParser();

    @Test
    public void testSuccessful() throws Exception {
        assertThat(parser.parse("PLACE -1,0,SOUTH"), instanceOf(PlaceCommand.class));
        assertThat(parser.parse("PLACE 3,   -2,NORTH"), instanceOf(PlaceCommand.class));
        assertThat(parser.parse("MOVE"), instanceOf(MoveCommand.class));
        assertThat(parser.parse("  RIGHT"), instanceOf(RightCommand.class));
        assertThat(parser.parse("LEFT \t"), instanceOf(LeftCommand.class));
        assertThat(parser.parse(" REPORT     "), instanceOf(ReportCommand.class));
    }

    @Test
    public void testEmptyString() throws Exception {
        assertThat(parser.parse(""), is(nullValue()));
        assertThat(parser.parse("     "), is(nullValue()));
        assertThat(parser.parse("\r\n"), is(nullValue()));
        assertThat(parser.parse("\n"), is(nullValue()));
    }

    @Test
    public void testIncorrectNumberOfTokens() throws Exception {
        final String[] badCommands = {
            "PLACE", "PLACE 1", "PLACE 1,2", "PLACE 1,2,", "PLACE 1,2,SOUTH,X",
            "MOVE 3",
            "RIGHT D",
            "LEFT 8",
            "REPORT 15"
        };
        assertBadCommands(badCommands);
    }

    @Test
    public void testIncorrectTokens() {
        final String[] badCommands = {
                "PLACE A,2,SOUTH", "PLACE 1,B,NORTH", "PLACE 1,2, NOWHERE"
        };
        assertBadCommands(badCommands);
    }

    @Test
    public void testIncorrectCommands() {
        final String[] badCommands = {
                "place 1,2,SOUTH", "PLACE 1,2,south", "NONSENSE", "A B",
                "report", "Move", "left"
        };
        assertBadCommands(badCommands);
    }

    private void assertBadCommands(String[] badCommands) {
        for (String badCommand : badCommands) {
            try {
                parser.parse(badCommand);
                fail("Should not get here!");
            } catch (RobotCommandParseException e) {
                // OK
            }
        }
    }
}
