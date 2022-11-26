package model.airport.timeblocks.fourwheeler;

import model.TimeBlock;

public class TwelveToTwentyFourHourTimeBlock extends TimeBlock {

    public TwelveToTwentyFourHourTimeBlock(long startInterval, long endInterval, int feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
