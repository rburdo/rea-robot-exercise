package com.rburdo.coding.rea.robot;


public class RobotMoverReport {
    private Location location;
    private FacingDirection facingDirection;

    public RobotMoverReport(Location location, FacingDirection facingDirection) {
        this.location = location;
        this.facingDirection = facingDirection;
    }

    public Location getLocation() {
        return location;
    }

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

}
