package timeblocks;

import util.VehicleTypeEnum;

public class RegularTimeblock extends TimeBlock {
    public RegularTimeblock(Long startInterval, Long endInterval, Integer feeUnits, VehicleTypeEnum vehicleTypeEnum) {
        super(startInterval, endInterval, feeUnits, vehicleTypeEnum);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
