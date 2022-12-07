package timeblocks;

import util.Utility;
import util.VehicleTypeEnum;

import java.util.List;

public class TimeBlockFactory {

    final List<TimeBlock> timeBlocks;

    public TimeBlockFactory(List<TimeBlock> timeBlocks) {
        this.timeBlocks = timeBlocks;
    }

    public TimeBlock getTimeBlock(long hoursParked, VehicleTypeEnum vehicleTypeEnum) {

        return Utility.getTimeBlock(hoursParked, timeBlocks, vehicleTypeEnum);
    }
}
