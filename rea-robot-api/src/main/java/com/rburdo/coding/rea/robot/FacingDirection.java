package com.rburdo.coding.rea.robot;


public enum FacingDirection {
    NORTH, SOUTH, EAST, WEST;

    public FacingDirection getNextClockwise() {
        switch(this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException();
        }
    }

    public FacingDirection getNextCounterClockwise() {
        switch(this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalArgumentException();
        }
    }
}
