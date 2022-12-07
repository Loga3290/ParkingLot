package model.feemodels;

import model.ParkingTicket;
import util.VehicleTypeEnum;

import java.util.List;

public interface IFeeModel {
    /**
     * @param parkingTicket
     * @return
     */
    Integer calculateFee(ParkingTicket parkingTicket);

    /**
     * Method to get list of available parking types for the given FeeModel
     * @return
     */
    List<VehicleTypeEnum> getAvailableParkingTypes();
}
