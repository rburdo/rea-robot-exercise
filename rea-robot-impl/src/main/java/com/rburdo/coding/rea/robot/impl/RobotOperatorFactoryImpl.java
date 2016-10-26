package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.RobotOperator;
import com.rburdo.coding.rea.robot.RobotOperatorFactory;
import com.rburdo.coding.rea.robot.input.RobotCommandFactory;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;

public class RobotOperatorFactoryImpl implements RobotOperatorFactory {
    private Board board;

    public RobotOperatorFactoryImpl(Board board) {
        this.board = board;
    }

    @Override
    public RobotOperator create(RobotCommandFactory commandFactory, RobotReportPresenter reportPresenter) {
        return new RobotOperatorImpl(board, commandFactory, reportPresenter);
    }
}
