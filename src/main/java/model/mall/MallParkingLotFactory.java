package model.mall;

import exception.InvalidInputException;
import util.ErrorConstant;
import util.VehicleTypeEnum;

public class MallParkingLotFactory {

    private final MallParkingLot mallFWParking = new MallParkingLot(20, 60);
    private final MallParkingLot mallTWParking = new MallParkingLot(10, 60);
    private final MallParkingLot mallHVParking = new MallParkingLot(50, 60);

    public MallParkingLot getParkingImpl(VehicleTypeEnum vehicleTypeEnum){
        switch (vehicleTypeEnum){
            case TwoWheeler: return mallTWParking;
            case FourWheeler: return mallFWParking;
            case HeavyVehicle: return mallHVParking;
            default: throw new InvalidInputException(ErrorConstant.INVALID_VEHICLE_TYPE);
        }
    }
}
