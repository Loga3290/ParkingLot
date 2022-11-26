package model.airport;

import model.airport.timeblocks.fourwheeler.AirportFWTimeBlockFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirportFWParkingImpl implements IAirportParking {

    AirportFWTimeBlockFactory factory;

    public AirportFWParkingImpl(AirportFWTimeBlockFactory factory) {
        this.factory = factory;
    }


    @Override
    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.HOURS.between(startDate, LocalDateTime.now());
        return factory.getTimeBlock(hours).calculateFee(hours);
    }
}
