package model.airport.timeblocks.twowheeler;

import model.TimeBlock;

public class EightToTwentyFourHourTimeBlock extends TimeBlock {
    public EightToTwentyFourHourTimeBlock(long startInterval, long endInterval, int feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
