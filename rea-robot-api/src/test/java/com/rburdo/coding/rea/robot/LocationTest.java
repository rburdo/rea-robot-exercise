package com.rburdo.coding.rea.robot;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class LocationTest {

    @Test
    public void testAccessors() {
        Location location = new Location(2, 4);
        assertThat(location.getxLocation(), is(2));
        assertThat(location.getyLocation(), is(4));
    }

    @Test
    public void testEqualsAndHashCode() {
        Location location = new Location(2, 4);
        assertThat(location.equals(null), is(false));
        assertThat(location.equals(12), is(false));
        assertThat(location.equals(new Location(0, 0)), is(false));
        assertThat(location.equals(new Location(2, 0)), is(false));
        assertThat(location.equals(new Location(0, 4)), is(false));
        assertThat(location.equals(new Location(2, 4)), is(true));
        assertThat(location.hashCode(), not(is(0)));
    }

}
