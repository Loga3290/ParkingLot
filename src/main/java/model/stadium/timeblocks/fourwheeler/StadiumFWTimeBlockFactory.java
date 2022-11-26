package model.stadium.timeblocks.fourwheeler;

import model.TimeBlock;
import util.Utility;

import java.util.Arrays;
import java.util.List;

public class StadiumFWTimeBlockFactory {

    TimeBlock block1 = new ZeroToFourHourTimeBlock(0L, 4L, 60);
    TimeBlock block2 = new FourToTwelveHourTimeBlock(4L, 12L, 120);
    TimeBlock block3 = new TwelveToInfinityHourTimeBlock(12L, 1440L, 200, Arrays.asList(block1, block2));

    public  TimeBlock getTimeBlock(long hoursParked) {
        List<TimeBlock> airportTimeBlocks = Arrays.asList(block1, block2, block3);
        return Utility.getTimeBlock(hoursParked, airportTimeBlocks);
    }
}
