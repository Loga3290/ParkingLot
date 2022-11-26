package model.stadium;

import java.time.LocalDateTime;

public interface IStadiumParking {
    /**
     * Method to calculate the parking fee for the given vehicle in Mall
     * for the time parked
     * @param startDate
     * @return
     */
    Integer calculateFee(LocalDateTime startDate);
}
