package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.RobotOperator;
import com.rburdo.coding.rea.robot.impl.input.InputStreamRobotCommandFactoryFactory;
import com.rburdo.coding.rea.robot.impl.output.OutputStreamReportPresenterFactory;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml" })
public class RobotOperatorImplTest {
    private ByteArrayOutputStream outputStream;

    @Autowired
    private RobotOperatorFactoryImpl robotOperatorFactory;

    @Autowired
    private InputStreamRobotCommandFactoryFactory robotCommandFactoryFactory;

    @Autowired
    private OutputStreamReportPresenterFactory reportPresenterFactory;


    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testPerimieterPath() throws Exception {
        RobotOperator operator = createOperatorFromFile("perimeter-path.txt");
        operator.batchExecute();
        assertOutput("0,0,EAST", "3,0,EAST", "5,2,NORTH", "5,5,NORTH", "5,5,WEST", "0,5,SOUTH", "0,0,SOUTH");
    }

    @Test
    public void testRightAndLeft() throws Exception {
        RobotOperator operator = createOperatorFromFile("left-and-right.txt");
        operator.batchExecute();
        assertOutput("3,3,NORTH", "3,3,WEST", "3,3,SOUTH", "3,3,EAST",
                "3,3,SOUTH", "3,3,WEST", "3,3,NORTH", "3,3,EAST");
    }

    @Test
    public void testMultiplePlacements() throws Exception {
        RobotOperator operator = createOperatorFromFile("multiple-placements.txt");
        operator.batchExecute();
        assertOutput("3,2,EAST", "2,3,SOUTH", "0,4,WEST");
    }


    @Test
    public void testFirstCommandIsNotPlace() throws Exception {
        testFirstCommandIs("MOVE");
        testFirstCommandIs("RIGHT");
        testFirstCommandIs("LEFT");
        testFirstCommandIs("REPORT");
    }

    private void testFirstCommandIs(String command) throws Exception {
        RobotOperator operator = createOperatorFromString(command);
        operator.batchExecute();
        Robot robot = (Robot) ReflectionTestUtils.getField(operator, "robot");
        assertThat(robot.getLocation(), is(nullValue()));
        assertThat(robot.getFacingDirection(), is(nullValue()));
    }


    @Test
    public void testNonExistingInputSource() throws Exception {
        try {
            RobotOperator operator = createOperatorFromFile("non-existent.txt");
            operator.batchExecute();
        } catch (IOException e) {
            // OK
        }
    }

    @Test
    public void testNonExistingOutputDestination() throws Exception {
        try {
            outputStream = null;
            RobotOperator operator = createOperatorFromFile("perimeter-path.txt");
            operator.batchExecute();
        } catch (IOException e) {
            // OK
        }
    }

    private RobotOperator createOperatorFromFile(String inputFile) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/test-paths/" + inputFile);

        return robotOperatorFactory.create(robotCommandFactoryFactory.create(inputStream),
                reportPresenterFactory.create(outputStream));
    }

    private RobotOperator createOperatorFromString(String commandStr) throws IOException {
        InputStream inputStream = IOUtils.toInputStream(commandStr, "UTF-8");

        return robotOperatorFactory.create(robotCommandFactoryFactory.create(inputStream),
                reportPresenterFactory.create(outputStream));
    }

    private void assertOutput(String... expectedOutput) {
        assertThat(StringUtils.split(outputStream.toString(), "\n\r"), is(expectedOutput));
    }
}
