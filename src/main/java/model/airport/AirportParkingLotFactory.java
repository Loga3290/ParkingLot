package model.airport;

import exception.InvalidInputException;
import model.airport.timeblocks.fourwheeler.AirportFWTimeBlockFactory;
import model.airport.timeblocks.twowheeler.AirportTWTimeBlockFactory;
import util.ErrorConstant;
import util.VehicleTypeEnum;

public class AirportParkingLotFactory {

    IAirportParking airportFWParking = new AirportFWParkingImpl(new AirportFWTimeBlockFactory());
    IAirportParking airportTWParking = new AirportTWParkingImpl(new AirportTWTimeBlockFactory());

    public IAirportParking getParkingImpl(VehicleTypeEnum vehicleTypeEnum){
        switch (vehicleTypeEnum){
            case TwoWheeler: return airportTWParking;
            case FourWheeler: return airportFWParking;
            default: throw new InvalidInputException(ErrorConstant.INVALID_VEHICLE_TYPE);
        }
    }
}
