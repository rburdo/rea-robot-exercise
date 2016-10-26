package com.rburdo.coding.rea.robot.impl;


import com.rburdo.coding.rea.robot.FacingDirection;
import com.rburdo.coding.rea.robot.Location;

public class Robot {
    private Board               board;
    private Location            location;
    private FacingDirection     facingDirection;

    public Robot(Board board) {
        this.board = board;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if (board.isValid(location)) {
            this.location = location;
        }
    }

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }

}
