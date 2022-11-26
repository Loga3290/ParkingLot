package model.mall;

import exception.InvalidInputException;
import util.ErrorConstant;
import util.VehicleTypeEnum;

public class MallParkingLotFactory {

    private final IMallParking mallFWParking = new MallFWParkingImpl(20);
    private final IMallParking mallTWParking = new MallTWParkingImpl(10);
    private final IMallParking mallHVParking = new MallHVParkingImpl(50);

    public IMallParking getParkingImpl(VehicleTypeEnum vehicleTypeEnum){
        switch (vehicleTypeEnum){
            case TwoWheeler: return mallTWParking;
            case FourWheeler: return mallFWParking;
            case HeavyVehicle: return mallHVParking;
            default: throw new InvalidInputException(ErrorConstant.INVALID_VEHICLE_TYPE);
        }
    }
}
