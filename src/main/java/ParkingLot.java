import exception.InvalidInputException;
import model.*;
import model.feemodels.FeeModelEnum;
import model.feemodels.FeeModelFactory;
import model.feemodels.IFeeModel;
import model.vehicle.IVehicle;
import util.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private final List<AvailableSpace> space;
    private final IFeeModel feeModel;
    private List<ParkingTicket> issuedTickets = new ArrayList<>();
    private ReceiptSequenceGenerator receiptSequenceGenerator = new ReceiptSequenceGenerator();
    private TicketSequenceGenerator ticketSequenceGenerator = new TicketSequenceGenerator();

    public ParkingLot(Map<VehicleEnum, Integer> spaceMap, FeeModelEnum feeModelEnum) {
        space = spaceMap.entrySet().stream().map(
                vehicleTypeEnumIntegerEntry -> new AvailableSpace(
                        VehicleTypeEnum.valueOf(vehicleTypeEnumIntegerEntry.getKey().getVehicleType()),
                        vehicleTypeEnumIntegerEntry.getValue()
                )).collect(Collectors.toList());
        FeeModelFactory feeModelFactory = new FeeModelFactory();
        this.feeModel = feeModelFactory.getFeeModelImpl(feeModelEnum);

        for (AvailableSpace availableSpace : space) {
            if (!feeModel.getAvailableParkingTypes().contains(availableSpace.getVehicleType())) {
                throw new InvalidInputException(ErrorConstant.NO_PARKING_SPACE_AVL);
            }
        }
    }

    public ParkingTicket park(IVehicle vehicle, LocalDateTime entryDateTime) {
        //Check if the parking space exists for the given vehicleType
        AvailableSpace vehicleSpace = space.stream().filter(availableSpace ->
                availableSpace.getVehicleType() == vehicle.getType()
        ).findFirst().orElseThrow(() -> new InvalidInputException(ErrorConstant.SPACE_NOT_AVAILABLE));

        //Check if the parking is full
        if (vehicleSpace.getSpotList().isEmpty()) {
            throw new InvalidInputException(ErrorConstant.NO_SPOTS_AVAILABLE);
        }

        //Get the first available spot to park the vehicle
        Spot first = vehicleSpace.getSpotList().getFirst();

        //Create ticket
        ParkingTicket ticket = new ParkingTicket();
        ticket.setTicketNo(ticketSequenceGenerator.getNext());
        ticket.setSpot(first);
        ticket.setEntryDateTime(entryDateTime);
        ticket.setVehicleType(vehicle.getType());
        vehicleSpace.getSpotList().removeFirst();

        //Add ticket to issuedTickets list
        issuedTickets.add(ticket);
        return ticket;
    }

    public ParkingReceipt unpark(Integer ticketNo) {
        //Check if the ticket exists
        ParkingTicket parkingTicket = issuedTickets.stream().filter(
                ticket -> ticket.getTicketNo() == ticketNo).findFirst()
                .orElseThrow(() -> new InvalidInputException(ErrorConstant.TICKET_NOT_AVAILABLE));

        //Add spot back to available space
        AvailableSpace vehicleSpace = space.stream().filter(availableSpace ->
                availableSpace.getVehicleType() == parkingTicket.getVehicleType()
        ).findFirst().orElseThrow(() -> new InvalidInputException(ErrorConstant.SPACE_NOT_AVAILABLE));
        Spot spot = parkingTicket.getSpot();
        vehicleSpace.getSpotList().add(spot);

        //Calculate Fee and return receipt
        Integer fee = this.feeModel.calculateFee(parkingTicket);
        ParkingReceipt receipt = new ParkingReceipt();
        receipt.setReceiptNo(receiptSequenceGenerator.getNext());
        receipt.setEntryDate(parkingTicket.getEntryDateTime());
        receipt.setExitDate(LocalDateTime.now());
        receipt.setFee(fee);

        //Remove the parking ticket from the list
        issuedTickets.remove(parkingTicket);
        return receipt;
    }
}
