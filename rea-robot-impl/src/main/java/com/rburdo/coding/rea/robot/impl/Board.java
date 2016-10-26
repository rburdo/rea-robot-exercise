package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.Location;

public class Board {
    private Integer minX;
    private Integer maxX;
    private Integer minY;
    private Integer maxY;

    public Board(Integer minX, Integer maxX, Integer minY, Integer maxY) {
        if (minX > maxX) {
            throw new IllegalArgumentException("minX must not be greater than maxX");
        }
        if (minY > maxY) {
            throw new IllegalArgumentException("minY must not be greater than maxY");
        }

        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public Integer getMinX() {
        return minX;
    }

    public Integer getMaxX() {
        return maxX;
    }

    public Integer getMinY() {
        return minY;
    }

    public Integer getMaxY() {
        return maxY;
    }

    public boolean isValid(Location location) {
        return location.getxLocation() >= getMinX()
                && location.getxLocation() <= getMaxX()
                && location.getyLocation() >= getMinX()
                && location.getyLocation() <= getMaxY();
    }
}
