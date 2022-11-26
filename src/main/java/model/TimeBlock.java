package model;

import lombok.Data;

/**
 * Time period with start and end intervals which represents
 * the boundary unit of time in each parking
 */
@Data
public abstract class TimeBlock {

    final private Long startInterval;
    final private Long endInterval;
    final private Integer feeUnits;

    protected TimeBlock(Long startInterval, Long endInterval, Integer feeUnits) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.feeUnits = feeUnits;
    }

    public abstract Integer calculateFee(long hours);
}
