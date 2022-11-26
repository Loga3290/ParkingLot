package model.stadium.timeblocks.twowheeler;

import model.TimeBlock;
import util.Utility;

import java.util.List;

public class TwelveToInfinityHourTimeBlock extends TimeBlock {
    private final List<TimeBlock> otherTimeBlockList;

    public TwelveToInfinityHourTimeBlock(long startInterval, long endInterval, int feeUnits, List<TimeBlock> otherTimeBlockList) {
        super(startInterval, endInterval, feeUnits);
        this.otherTimeBlockList = otherTimeBlockList;
    }

    @Override
    public Integer calculateFee(long hours) {
        Integer sumOfFeeUnits = Utility.getSumOfFeeUnits(otherTimeBlockList);
        Long maxIntervalTime = Utility.getMaxIntervalTime(otherTimeBlockList);
        return sumOfFeeUnits + Math.toIntExact((hours - maxIntervalTime) * this.getFeeUnits());
    }
}
