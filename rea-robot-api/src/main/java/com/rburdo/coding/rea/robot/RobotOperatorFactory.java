package com.rburdo.coding.rea.robot;


import com.rburdo.coding.rea.robot.input.RobotCommandFactory;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;

public interface RobotOperatorFactory {

    RobotOperator create(RobotCommandFactory commandFactory, RobotReportPresenter reportPresenter);

}
