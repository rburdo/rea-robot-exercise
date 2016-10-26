package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.RobotException;
import com.rburdo.coding.rea.robot.RobotOperator;
import com.rburdo.coding.rea.robot.impl.input.command.BaseRobotCommand;
import com.rburdo.coding.rea.robot.impl.input.command.ReportCommand;
import com.rburdo.coding.rea.robot.input.RobotCommandFactory;
import com.rburdo.coding.rea.robot.input.command.RobotCommand;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;

import java.io.IOException;
import java.util.List;

public class RobotOperatorImpl implements RobotOperator {
    private Robot                   robot;
    private RobotCommandFactory     commandFactory;
    private RobotReportPresenter    reportPresenter;

    public RobotOperatorImpl(Board board, RobotCommandFactory commandFactory, RobotReportPresenter reportPresenter) {
        this.robot = new Robot(board);
        this.commandFactory = commandFactory;
        this.reportPresenter = reportPresenter;
    }

    public void batchExecute() throws RobotException {
        try {
            List<RobotCommand> commands = commandFactory.getAllCommands();
            for (RobotCommand command : commands) {
                if (BaseRobotCommand.class.isInstance(command)) {
                    ((BaseRobotCommand) command).setRobot(robot);
                }
                if (ReportCommand.class.isInstance(command)) {
                    ((ReportCommand) command).setPresenter(reportPresenter);
                }
                command.execute();
            }
        } catch (IOException e) {
            throw new RobotException("Failed to batch execute robot commands", e);
        }
    }

}
