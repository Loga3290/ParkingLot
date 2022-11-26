package model;

import model.airport.AirportParkingLotFactory;
import util.VehicleTypeEnum;

import java.util.Arrays;
import java.util.List;

public class AirportFeeModelImpl implements IFeeModel {

    AirportParkingLotFactory factory;

    public AirportFeeModelImpl(AirportParkingLotFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer calculateFee(ParkingTicket parkingTicket) {
        return factory.getParkingImpl(parkingTicket.getVehicleType())
                .calculateFee(parkingTicket.getEntryDateTime());
    }

    @Override
    public List<VehicleTypeEnum> getAvailableParkingTypes() {
        return Arrays.asList(VehicleTypeEnum.TwoWheeler, VehicleTypeEnum.FourWheeler);
    }
}
