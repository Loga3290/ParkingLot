package model.vehicle;

import lombok.Data;
import util.VehicleTypeEnum;

@Data
public abstract class IVehicle {
    private String regNo;
    private VehicleTypeEnum type;
    IVehicle(String regNo, VehicleTypeEnum type) {
        this.regNo = regNo;
        this.type = type;
    }
}
