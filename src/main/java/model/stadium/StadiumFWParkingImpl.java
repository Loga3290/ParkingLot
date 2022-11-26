package model.stadium;

import model.stadium.timeblocks.fourwheeler.StadiumFWTimeBlockFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StadiumFWParkingImpl implements IStadiumParking {

    final StadiumFWTimeBlockFactory factory;

    public StadiumFWParkingImpl(StadiumFWTimeBlockFactory factory) {
        this.factory = factory;
    }

    @Override
    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.HOURS.between(startDate, LocalDateTime.now());
        return factory.getTimeBlock(hours).calculateFee(hours);
    }
}
