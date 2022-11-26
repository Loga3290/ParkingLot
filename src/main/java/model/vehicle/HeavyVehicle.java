package model.vehicle;

import util.VehicleTypeEnum;

public class HeavyVehicle extends IVehicle{

    public HeavyVehicle(String regNo) {
        super(regNo, VehicleTypeEnum.HeavyVehicle);
    }
}
