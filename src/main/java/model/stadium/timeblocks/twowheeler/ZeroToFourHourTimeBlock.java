package model.stadium.timeblocks.twowheeler;

import model.TimeBlock;

public class ZeroToFourHourTimeBlock extends TimeBlock {
    public ZeroToFourHourTimeBlock(Long startInterval, Long endInterval, Integer feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
