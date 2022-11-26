package model.stadium.timeblocks.twowheeler;

import model.TimeBlock;
import util.Utility;

import java.util.Arrays;
import java.util.List;

public class StadiumTWTimeBlockFactory  {
    private static final TimeBlock block1 = new ZeroToFourHourTimeBlock(0L, 4L, 30);
    private static final TimeBlock block2 = new FourToTwelveHourTimeBlock(4L, 12L, 60);
    private static final TimeBlock block3 = new TwelveToInfinityHourTimeBlock(12L, 1440L, 100, Arrays.asList(block1, block2));

    public TimeBlock getTimeBlock(long hoursParked) {
        List<TimeBlock> airportTimeBlocks = Arrays.asList(block1, block2, block3);
        return Utility.getTimeBlock(hoursParked, airportTimeBlocks);
    }

}
