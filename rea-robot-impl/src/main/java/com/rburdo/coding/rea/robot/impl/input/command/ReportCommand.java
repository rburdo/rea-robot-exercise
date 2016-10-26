package com.rburdo.coding.rea.robot.impl.input.command;

import com.rburdo.coding.rea.robot.input.command.RobotCommand;
import com.rburdo.coding.rea.robot.RobotException;
import com.rburdo.coding.rea.robot.RobotMoverReport;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;


public class ReportCommand extends BaseRobotCommand implements RobotCommand {
    private RobotReportPresenter presenter;

    public void setPresenter(RobotReportPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() throws RobotException {
        if (verifyRobotOnBoard()) {
            RobotMoverReport report = new RobotMoverReport(getRobot().getLocation(), getRobot().getFacingDirection());
            presenter.present(report);
        }
    }

}
