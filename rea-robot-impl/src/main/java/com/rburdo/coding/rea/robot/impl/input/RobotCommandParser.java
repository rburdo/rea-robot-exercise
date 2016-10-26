package com.rburdo.coding.rea.robot.impl.input;


import com.rburdo.coding.rea.robot.RobotCommandParseException;
import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;
import com.rburdo.coding.rea.robot.impl.input.command.LeftCommand;
import com.rburdo.coding.rea.robot.impl.input.command.MoveCommand;
import com.rburdo.coding.rea.robot.impl.input.command.PlaceCommand;
import com.rburdo.coding.rea.robot.impl.input.command.ReportCommand;
import com.rburdo.coding.rea.robot.impl.input.command.RightCommand;
import org.apache.commons.lang3.StringUtils;

public class RobotCommandParser {
    private static final String SEPARATOR = ", ";
    private static final String PLACE = "PLACE";
    private static final String MOVE = "MOVE";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String REPORT = "REPORT";

    public RobotCommand parse(String commandStr) throws RobotCommandParseException {
        try {
            return StringUtils.isBlank(commandStr) ? null : doParse(commandStr.trim());
        } catch (RobotCommandParseException e) {
            throw e;
        } catch (Throwable th) {
            throw new RobotCommandParseException(th.getMessage(), commandStr, th);
        }
    }

    private RobotCommand doParse(String commandStr) throws RobotCommandParseException {
        String[] tokens = StringUtils.split(commandStr, SEPARATOR);
        switch (tokens[0]) {
            case PLACE :
                verifyNumberOfTokens(commandStr, tokens, 4, PLACE, "X, Y, DIRECTION");
                return new PlaceCommand(
                        Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]), FacingDirection.valueOf(tokens[3]));

            case MOVE :
                verifyNumberOfTokens(commandStr, tokens, 1, MOVE);
                return new MoveCommand();

            case LEFT :
                verifyNumberOfTokens(commandStr, tokens, 1, LEFT);
                return new LeftCommand();

            case RIGHT :
                verifyNumberOfTokens(commandStr, tokens, 1, RIGHT);
                return new RightCommand();

            case REPORT :
                verifyNumberOfTokens(commandStr, tokens, 1, REPORT);
                return new ReportCommand();

            default :
                throw new IllegalArgumentException("Unknown command : " + tokens[0]);
        }
    }


    private void verifyNumberOfTokens(String commandStr, String[] tokens, int expectedNumberOfToken,
                                      String... commandParts) throws RobotCommandParseException {
        if (tokens.length != expectedNumberOfToken) {
            throw new RobotCommandParseException("Format : " + StringUtils.join(commandParts, " "), commandStr);
        }
    }
}
