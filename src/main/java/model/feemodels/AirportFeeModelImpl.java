package model.feemodels;

import model.IFeeModel;
import model.ParkingTicket;
import timeblocks.TimeBlockFactory;
import util.VehicleTypeEnum;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class AirportFeeModelImpl implements IFeeModel {

    TimeBlockFactory factory;

    public AirportFeeModelImpl(TimeBlockFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer calculateFee(ParkingTicket parkingTicket) {
        long hoursParked = ChronoUnit.HOURS.between(parkingTicket.getEntryDateTime(), LocalDateTime.now());
        return factory
                .getTimeBlock(hoursParked, parkingTicket.getVehicleType())
                .calculateFee(hoursParked);
    }

    @Override
    public List<VehicleTypeEnum> getAvailableParkingTypes() {
        return Arrays.asList(VehicleTypeEnum.TwoWheeler, VehicleTypeEnum.FourWheeler);
    }
}
