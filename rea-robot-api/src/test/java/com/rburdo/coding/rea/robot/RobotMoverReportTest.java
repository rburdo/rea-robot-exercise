package com.rburdo.coding.rea.robot;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotMoverReportTest {

    @Test
    public void testAccessors() {
        RobotMoverReport report = new RobotMoverReport(new Location(1, 2), FacingDirection.NORTH);
        assertThat(report.getLocation().getxLocation(), is(1));
        assertThat(report.getLocation().getyLocation(), is(2));
        assertThat(report.getFacingDirection(), is(FacingDirection.NORTH));
    }
}
