package model.airport;

import model.airport.timeblocks.twowheeler.AirportTWTimeBlockFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AirportTWParkingImpl implements IAirportParking {

    private final AirportTWTimeBlockFactory airportTWTimeBlockFactory;

    public AirportTWParkingImpl(AirportTWTimeBlockFactory airportTWTimeBlockFactory) {
        this.airportTWTimeBlockFactory = airportTWTimeBlockFactory;
    }

    @Override
    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.HOURS.between(startDate, LocalDateTime.now());
        return airportTWTimeBlockFactory.getTimeBlock(hours).calculateFee(hours);
    }
}
