package model.airport.timeblocks.twowheeler;

import model.TimeBlock;
import util.Utility;

import java.util.Arrays;
import java.util.List;

/**
 * Airport Two wheeler Parking Time Blocks
 */
public class AirportTWTimeBlockFactory {

    private static final TimeBlock block1 = new ZeroToOneHourTimeBlock(0L, 1L, 0);
    private static final TimeBlock block2 = new OneToEightHourTimeBlock(1L, 8L, 40);
    private static final TimeBlock block3 = new EightToTwentyFourHourTimeBlock(8L, 24L, 60);
    private static final TimeBlock block4 = new TwentyFourToInfinityHourTimeBlock(24L, 1440L, 80);

    /**
     * Method to Time blocks for Two wheeler
     * @param hoursParked
     * @return
     */
    public TimeBlock getTimeBlock(long hoursParked) {
        List<TimeBlock> airportTimeBlocks = Arrays.asList(block1, block2, block3, block4);
        return Utility.getTimeBlock(hoursParked, airportTimeBlocks);
    }
}
