package model.stadium.timeblocks.fourwheeler;

import model.TimeBlock;
import util.Utility;

import java.util.List;

public class TwelveToInfinityHourTimeBlock extends TimeBlock {

    private final List<TimeBlock> otherTimeBlocks;

    public TwelveToInfinityHourTimeBlock(long startInterval, long endInterval, int feeUnits, List<TimeBlock> otherTimeBlocks) {
        super(startInterval, endInterval, feeUnits);
        this.otherTimeBlocks = otherTimeBlocks;
    }

    @Override
    public Integer calculateFee(long hours) {
        Integer sumOfFeeUnits = Utility.getSumOfFeeUnits(otherTimeBlocks);
        Long maxIntervalTime = Utility.getMaxIntervalTime(otherTimeBlocks);
        return sumOfFeeUnits + Math.toIntExact((hours - maxIntervalTime) * this.getFeeUnits());
    }

}
