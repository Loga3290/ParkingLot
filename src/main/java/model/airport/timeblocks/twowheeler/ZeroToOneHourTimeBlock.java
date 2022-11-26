package model.airport.timeblocks.twowheeler;

import model.TimeBlock;

public class ZeroToOneHourTimeBlock extends TimeBlock {
    public ZeroToOneHourTimeBlock(Long startInterval, Long endInterval, Integer feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return this.getFeeUnits();
    }
}
