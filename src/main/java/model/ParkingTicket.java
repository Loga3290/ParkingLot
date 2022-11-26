package model;

import lombok.Data;
import util.VehicleTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Parking Ticket Model
 */
@Data
public class ParkingTicket {
    private VehicleTypeEnum vehicleType;
    private Spot spot;
    private Integer ticketNo;
    private LocalDateTime entryDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTicket that = (ParkingTicket) o;
        return Objects.equals(ticketNo, that.ticketNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNo);
    }
}
