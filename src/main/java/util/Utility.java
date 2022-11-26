package util;

import exception.InvalidInputException;
import model.TimeBlock;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    /**
     * Mehthod to get the TimeBlock where the parked hours falls
     * @param hoursParked
     * @param timeBlockStream
     * @return
     */
    public static TimeBlock getTimeBlock(long hoursParked, List<TimeBlock> timeBlockStream) {
        return timeBlockStream.stream().filter(
                        timeBlock -> hoursParked >= timeBlock.getStartInterval()
                                && hoursParked < timeBlock.getEndInterval()).findFirst()
                .orElseThrow(() -> new InvalidInputException(ErrorConstant.INVALID_TIMEBLOCK));
    }

    /**
     * Get the timeblock's end interval which has the longest timeframe from given time blocks
     * @param otherTimeBlocks
     * @return
     */
    public static Long getMaxIntervalTime(List<TimeBlock> otherTimeBlocks) {
        return otherTimeBlocks.stream()
                .max(Comparator.comparing(TimeBlock::getEndInterval))
                .orElseThrow(() -> new InvalidInputException(ErrorConstant.INVALID_TIMEBLOCK))
                .getEndInterval();
    }

    /**
     * Get the sum of fee units for the given timeblocks
     * @param otherTimeBlocks
     * @return
     */
    public static Integer getSumOfFeeUnits(List<TimeBlock> otherTimeBlocks) {
        return otherTimeBlocks.stream().collect(Collectors.summingInt(TimeBlock::getFeeUnits));
    }
}
