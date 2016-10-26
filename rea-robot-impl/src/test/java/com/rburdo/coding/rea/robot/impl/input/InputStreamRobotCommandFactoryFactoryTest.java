package com.rburdo.coding.rea.robot.impl.input;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class InputStreamRobotCommandFactoryFactoryTest {
    private InputStreamRobotCommandFactoryFactory factory;

    @Mock
    private RobotCommandParser parser;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        factory = new InputStreamRobotCommandFactoryFactory(parser);
    }

    @Test
    public void testEmptyCreate() throws Exception {
        InputStreamRobotCommandFactory commandFactory = factory.create();
        assertThat(ReflectionTestUtils.getField(commandFactory, "inputStream"), is(System.in));
        assertThat(ReflectionTestUtils.getField(commandFactory, "robotCommandParser"), is(parser));
    }

    @Test
    public void testParameterizedCreate() throws Exception {
        InputStream inputStream = mock(InputStream.class);
        InputStreamRobotCommandFactory commandFactory = factory.create(inputStream);
        assertThat(ReflectionTestUtils.getField(commandFactory, "inputStream"), is(inputStream));
        assertThat(ReflectionTestUtils.getField(commandFactory, "robotCommandParser"), is(parser));
    }
}
