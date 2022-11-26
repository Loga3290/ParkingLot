package model;

import model.stadium.StadiumParkingLotFactory;
import util.VehicleTypeEnum;

import java.util.Arrays;
import java.util.List;

public class StadiumFeeModelImpl implements IFeeModel {

    private final StadiumParkingLotFactory factory ;

    public StadiumFeeModelImpl(StadiumParkingLotFactory factory) {
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
