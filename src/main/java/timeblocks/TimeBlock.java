package timeblocks;

import lombok.Data;
import util.VehicleTypeEnum;

/**
 * Time period with start and end intervals which represents
 * the boundary unit of time in each parking
 */
@Data
public abstract class TimeBlock {

    final private Long startInterval;
    final private Long endInterval;
    final private Integer feeUnits;
    final private VehicleTypeEnum vehicleTypeEnum;

    protected TimeBlock(Long startInterval, Long endInterval, Integer feeUnits, VehicleTypeEnum vehicleTypeEnum) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.feeUnits = feeUnits;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public abstract Integer calculateFee(long hours);
}
