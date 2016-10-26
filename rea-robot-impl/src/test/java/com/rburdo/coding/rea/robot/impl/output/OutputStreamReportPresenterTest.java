package com.rburdo.coding.rea.robot.impl.output;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;
import com.rburdo.coding.rea.robot.RobotMoverReport;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OutputStreamReportPresenterTest {
    private OutputStreamReportPresenter presenter;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream(1000);
        presenter = new OutputStreamReportPresenter(outputStream);
    }

    @Test
    public void testSuccess() throws Exception {
        RobotMoverReport report = new RobotMoverReport(new Location(1, 2), FacingDirection.WEST);
        presenter.present(report);
        assertThat(outputStream.toString(), is("1,2,WEST" + System.lineSeparator()));
    }

    @Test
    public void testMissingData() throws Exception {
        RobotMoverReport report = new RobotMoverReport(new Location(1, 2), null);
        presenter.present(report);
        assertThat(outputStream.toString(), is("1,2,null" + System.lineSeparator()));
    }

    @Test(expected = IOException.class)
    public void testStreamError() throws Exception {
        RobotMoverReport report = new RobotMoverReport(new Location(1, 2), FacingDirection.EAST);
        presenter = new OutputStreamReportPresenter(new FileOutputStream("/blah"));
        presenter.present(report);
    }

}
