package model.stadium;

import exception.InvalidInputException;
import model.stadium.timeblocks.fourwheeler.StadiumFWTimeBlockFactory;
import model.stadium.timeblocks.twowheeler.StadiumTWTimeBlockFactory;
import util.ErrorConstant;
import util.VehicleTypeEnum;

public class StadiumParkingLotFactory {
    IStadiumParking stadiumFWParking = new StadiumFWParkingImpl(new StadiumFWTimeBlockFactory());
    IStadiumParking stadiumTWParking = new StadiumTWParkingImpl(new StadiumTWTimeBlockFactory());

    public IStadiumParking getParkingImpl(VehicleTypeEnum vehicleTypeEnum){
        switch (vehicleTypeEnum){
            case TwoWheeler: return stadiumTWParking;
            case FourWheeler: return stadiumFWParking;
            default: throw new InvalidInputException(ErrorConstant.INVALID_VEHICLE_TYPE);
        }
    }

}
