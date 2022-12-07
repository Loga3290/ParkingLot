package model.feemodels;

import model.ParkingTicket;
import model.mall.MallParkingLotFactory;
import util.VehicleTypeEnum;

import java.util.Arrays;
import java.util.List;

public class MallFeeModelImpl implements IFeeModel {

    private final MallParkingLotFactory factory ;

    public MallFeeModelImpl(MallParkingLotFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer calculateFee(ParkingTicket parkingTicket) {
        return factory.getParkingImpl(parkingTicket.getVehicleType()).calculateFee(parkingTicket.getEntryDateTime());
    }

    @Override
    public List<VehicleTypeEnum> getAvailableParkingTypes() {
        return Arrays.asList(VehicleTypeEnum.TwoWheeler, VehicleTypeEnum.FourWheeler, VehicleTypeEnum.HeavyVehicle);
    }
}
