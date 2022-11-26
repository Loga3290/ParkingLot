package model.airport;

import java.time.LocalDateTime;

public interface IAirportParking {
    /**
     * Method to calculate the parking fee for the given vehicle in airport
     * for the time parked
     * @param startDate
     * @return
     */
    Integer calculateFee(LocalDateTime startDate);
}
