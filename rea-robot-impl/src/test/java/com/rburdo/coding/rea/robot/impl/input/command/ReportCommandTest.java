package com.rburdo.coding.rea.robot.impl.input.command;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import com.rburdo.coding.rea.robot.RobotMoverReport;
import com.rburdo.coding.rea.robot.output.RobotReportPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;

public class ReportCommandTest extends BaseCommandTest {
    @Mock
    private RobotReportPresenter presenter;

    @Before
    public void setUp() {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReportCommand() throws Exception {
        ReportCommand command = new ReportCommand();
        command.setRobot(getRobot());
        command.setPresenter(presenter);
        getRobot().setLocation(new Location(2, 3));
        getRobot().setFacingDirection(FacingDirection.SOUTH);

        command.execute();
        verify(presenter).present(argThat(new ArgumentMatcher<RobotMoverReport>() {
            @Override
            public boolean matches(Object obj) {
                assertThat(obj, is(notNullValue()));
                assertThat(obj, instanceOf(RobotMoverReport.class));

                RobotMoverReport report = (RobotMoverReport) obj;
                assertThat(report.getLocation(), is(new Location(2, 3)));
                assertThat(report.getFacingDirection(), is(FacingDirection.SOUTH));
                return true;
            }
        }));
    }
}
