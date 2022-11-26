package model.vehicle;

import util.VehicleTypeEnum;

public class FourWheeler extends IVehicle {

    public FourWheeler(String regNo) {
        super(regNo, VehicleTypeEnum.FourWheeler);
    }
}
