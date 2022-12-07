package model.mall;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MallParkingLot {

    private final int feeUnits;
    private final long timeUnits;

    public MallParkingLot(int feeUnits, long timeUnits) {
        this.feeUnits = feeUnits;
        this.timeUnits = timeUnits;
    }

    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.MINUTES.between(startDate, LocalDateTime.now());
        return Math.toIntExact((hours / timeUnits) * this.feeUnits) + (Math.toIntExact(hours % timeUnits) > 0 ? this.feeUnits : 0);
    }
}
