package timeblocks;

import util.Utility;
import util.VehicleTypeEnum;

import java.util.List;

public class EachHourTimeblock extends TimeBlock{
    private final List<TimeBlock> otherTimeBlocks;

    public EachHourTimeblock(long startInterval, long endInterval, int feeUnits, VehicleTypeEnum vehicleTypeEnum, List<TimeBlock> otherTimeBlocks) {
        super(startInterval, endInterval, feeUnits, vehicleTypeEnum);
        this.otherTimeBlocks = otherTimeBlocks;
    }

    @Override
    public Integer calculateFee(long hours) {
        Integer sumOfFeeUnits = Utility.getSumOfFeeUnits(otherTimeBlocks);
        Long maxIntervalTime = Utility.getMaxIntervalTime(otherTimeBlocks);
        return sumOfFeeUnits + Math.toIntExact((hours - maxIntervalTime) * this.getFeeUnits());
    }
}
