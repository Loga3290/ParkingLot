package model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Parking Receipt Model
 */
@Data
public class ParkingReceipt {
    private Integer receiptNo;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Integer fee;
}
