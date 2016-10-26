package com.rburdo.coding.rea.robot.impl.output;


import com.rburdo.coding.rea.robot.RobotMoverReport;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;

import java.io.OutputStream;
import java.io.PrintStream;

public class OutputStreamReportPresenter implements RobotReportPresenter {
    private PrintStream printStream;

    public OutputStreamReportPresenter(OutputStream outputStream) {
        printStream = new PrintStream(outputStream);
    }

    public void present(RobotMoverReport report) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(report.getLocation().getxLocation()).append(",")
                .append(report.getLocation().getyLocation()).append(",")
                .append(report.getFacingDirection());
        printStream.println(stringBuilder.toString());
    }

}
