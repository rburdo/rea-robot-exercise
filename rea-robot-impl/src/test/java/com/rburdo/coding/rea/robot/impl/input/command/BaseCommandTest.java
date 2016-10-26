package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.impl.Board;
import com.rburdo.coding.rea.robot.impl.Robot;
import org.junit.Before;

abstract class BaseCommandTest {
    private Board board = new Board(-3, 3, -3, 3);
    private Robot robot;

    @Before
    public void setUp() {
        robot = new Robot(getBoard());
    }

    protected Board getBoard() {
        return board;
    }

    protected Robot getRobot() {
        return robot;
    }
}
