package model.stadium.timeblocks.fourwheeler;

import model.TimeBlock;

public class FourToTwelveHourTimeBlock extends TimeBlock {
    public FourToTwelveHourTimeBlock(long startInterval, long endInterval, int feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
