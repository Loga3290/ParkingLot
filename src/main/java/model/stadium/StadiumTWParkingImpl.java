package model.stadium;

import model.stadium.timeblocks.twowheeler.StadiumTWTimeBlockFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StadiumTWParkingImpl implements IStadiumParking {

    final StadiumTWTimeBlockFactory factory;

    public StadiumTWParkingImpl(StadiumTWTimeBlockFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.HOURS.between(startDate, LocalDateTime.now());
        return factory.getTimeBlock(hours).calculateFee(hours);
    }
}
