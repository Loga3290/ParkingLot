package model.airport.timeblocks.fourwheeler;

import model.TimeBlock;
import util.Utility;

import java.util.Arrays;
import java.util.List;

/**
 * Airport Four Wheeler Time Block Factory
 */
public class AirportFWTimeBlockFactory {
    private static final TimeBlock block1 = new ZeroToTwelveHourTimeBlock(0L, 12L, 60);
    private static final TimeBlock block2 = new TwelveToTwentyFourHourTimeBlock(8L, 24L, 80);
    private static final TimeBlock block3 = new TwentyFourToInfinityHourTimeBlock(24L, 1440L, 100);


    /**
     * Method to getTimeblock for the given hours parked
     * @param hoursParked
     * @return
     */
    public TimeBlock getTimeBlock(long hoursParked) {
        List<TimeBlock> airportTimeBlocks = Arrays.asList(block1, block2, block3);
        return Utility.getTimeBlock(hoursParked, airportTimeBlocks);
    }

}
