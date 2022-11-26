package model;

import lombok.Data;

/**
 * Spot where the vehicle are parked
 */
@Data
public class Spot {
    private Integer spotNo;

    public Spot(int spotNo) {
        this.spotNo = spotNo;
    }
}
