package model.vehicle;

import util.VehicleTypeEnum;

public class TwoWheeler extends IVehicle{

    public TwoWheeler(String regNo) {
        super(regNo, VehicleTypeEnum.TwoWheeler);
    }
}
