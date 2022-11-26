package model.airport.timeblocks.fourwheeler;

import model.TimeBlock;

public class TwentyFourToInfinityHourTimeBlock extends TimeBlock {
    public TwentyFourToInfinityHourTimeBlock(long startInterval, long endInterval, int feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {
        return Math.toIntExact(hours / 24L * this.getFeeUnits()) + (Math.toIntExact(hours % 24L) > 0 ? 100 : 0);
    }
}
