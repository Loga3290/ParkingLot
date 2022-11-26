package model.mall;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MallTWParkingImpl implements IMallParking {

    private final int feeUnits;

    public MallTWParkingImpl(int feeUnits) {
        this.feeUnits = feeUnits;
    }

    @Override
    public Integer calculateFee(LocalDateTime startDate) {
        long hours = ChronoUnit.MINUTES.between(startDate, LocalDateTime.now());
        return Math.toIntExact((hours / 60L) * this.feeUnits) + (Math.toIntExact(hours % 60L) > 0 ? this.feeUnits : 0);
    }
}
