package model.airport.timeblocks.twowheeler;

import model.TimeBlock;

public class TwentyFourToInfinityHourTimeBlock extends TimeBlock {
    public TwentyFourToInfinityHourTimeBlock(long startInterval, long endInterval, int feeUnits) {
        super(startInterval, endInterval, feeUnits);
    }

    @Override
    public Integer calculateFee(long hours) {

        //If the parked time is more than 24 hours, and it has a remainder, the next day is charged
        return Math.toIntExact(hours / 24L * this.getFeeUnits()) + (Math.toIntExact(hours % 24L) > 0 ? 80 : 0);
    }
}
