package timeblocks;

import util.VehicleTypeEnum;

public class EachDayTimeblock extends TimeBlock{

    public EachDayTimeblock(long startInterval, long endInterval, int feeUnits, VehicleTypeEnum vehicleTypeEnum) {
        super(startInterval, endInterval, feeUnits, vehicleTypeEnum);
    }

    @Override
    public Integer calculateFee(long hours) {
        return Math.toIntExact(hours / 24L * this.getFeeUnits()) + (Math.toIntExact(hours % 24L) > 0 ? this.getFeeUnits() : 0);
    }
}
