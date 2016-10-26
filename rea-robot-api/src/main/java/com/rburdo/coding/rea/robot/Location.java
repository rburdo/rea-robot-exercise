package com.rburdo.coding.rea.robot;


import java.util.Objects;

public class Location {
    private Integer xLocation;
    private Integer yLocation;

    public Location(Integer xLocation, Integer yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public Integer getxLocation() {
        return xLocation;
    }

    public Integer getyLocation() {
        return yLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(xLocation, location.xLocation) &&
                Objects.equals(yLocation, location.yLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLocation, yLocation);
    }

    @Override
    public String toString() {
        return new StringBuilder("(").append(xLocation).append(", ").append(yLocation).append(")").toString();
    }
}
