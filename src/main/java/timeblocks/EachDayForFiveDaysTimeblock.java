package timeblocks;

import util.VehicleTypeEnum;

import java.util.List;
import java.util.stream.Collectors;

public class EachDayForFiveDaysTimeblock extends TimeBlock{
    final List<TimeBlock> previousIntervals ;

    public EachDayForFiveDaysTimeblock(long startInterval, long endInterval, int feeUnits, VehicleTypeEnum vehicleTypeEnum, List<TimeBlock> previousIntervals) {
        super(startInterval, endInterval, feeUnits, vehicleTypeEnum);
        this.previousIntervals = previousIntervals;
    }

    @Override
    public Integer calculateFee(long hours) {

        Integer fee = previousIntervals.stream().collect(Collectors.summingInt(value -> value.calculateFee(value.getEndInterval())));
        int hoursParkedInThisTimeBlock = (int) (hours - getStartInterval());
        return fee + (hoursParkedInThisTimeBlock/24 * getFeeUnits()) + (hoursParkedInThisTimeBlock % 24 > 0 ? getFeeUnits() : 0);
    }
}
