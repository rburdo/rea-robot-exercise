package com.rburdo.coding.rea.robot.impl.output;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OutputStreamReportPresenterFactoryTest {
    private OutputStreamReportPresenterFactory factory = new OutputStreamReportPresenterFactory();

    @Test
    public void testEmptyCreate() throws Exception {
        OutputStreamReportPresenter presenter = factory.create();
        PrintStream printStream = (PrintStream) ReflectionTestUtils.getField(presenter, "printStream");
        assertThat(ReflectionTestUtils.getField(printStream, "out"), is(System.out));
    }

    @Test
    public void testParameterizedCreate() throws Exception {
        OutputStream outputStream = new ByteArrayOutputStream(200);
        OutputStreamReportPresenter presenter = factory.create(outputStream);
        PrintStream printStream = (PrintStream) ReflectionTestUtils.getField(presenter, "printStream");
        assertThat(ReflectionTestUtils.getField(printStream, "out"), is(outputStream));
    }
}
