import exception.InvalidInputException;
import model.ParkingReceipt;
import model.ParkingTicket;
import model.vehicle.FourWheeler;
import model.vehicle.HeavyVehicle;
import model.vehicle.IVehicle;
import model.vehicle.TwoWheeler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ErrorConstant;
import util.VehicleEnum;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Used Behaviour Driven Testing using junits
 * Class to check Stadium Fee model parking and unparking scenarios
 */
public class StadiumParkingLotTest {

    private ParkingLot parkingLot;

    /**
     * Method to create a Stadium Parking lot object with
     * Given Feemodel and spaces
     */
    @Before
    public void executeBefore(){
        Map<VehicleEnum, Integer> space = new HashMap<>();
        space.put(VehicleEnum.motorcycle, 10);
        space.put(VehicleEnum.car, 10);
        parkingLot = new ParkingLot(space, FeeModelEnum.STADIUM);
    }


    //Parking Tests
    @Test
    public void testParkTruckWhichDoNotHaveSpaceAllotted(){


        IVehicle vehicle = new HeavyVehicle("TN99J0398");
        try {
             parkingLot.park(vehicle, LocalDateTime.now().minusDays(1));
        }
        catch (InvalidInputException exception){
            assertEquals(exception.getMessage(), ErrorConstant.SPACE_NOT_AVAILABLE);
        }

    }

    @Test
    public void testParkHeavyVehicleWhichIsNotPartOfAirportFeeModel(){
        Map<VehicleEnum, Integer> space = new HashMap<>();
        space.put(VehicleEnum.scooter, 10);
        space.put(VehicleEnum.SUV, 10);

        try {
            new ParkingLot(space, FeeModelEnum.STADIUM);
        }
        catch (InvalidInputException exception){
            assertEquals(exception.getMessage(), ErrorConstant.NO_PARKING_SPACE_AVL);
        }

    }

    @Test
    public void testParkTwoWheelerWhenNoSpotsLeft(){


        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        IVehicle vehicle2 = new TwoWheeler("TN99J0389");
        parkingLot.park(vehicle1, LocalDateTime.now().minusDays(1));
        try {
            parkingLot.park(vehicle2, LocalDateTime.now().minusDays(1));
        }
        catch (InvalidInputException exception){
            assertEquals(exception.getMessage(), ErrorConstant.NO_SPOTS_AVAILABLE);
        }

    }

    @Test
    public void testParkVehicleWhenSpotsAvailable(){

        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        IVehicle vehicle2 = new FourWheeler("TN99J0389");

        try {
            parkingLot.park(vehicle1, LocalDateTime.now().minusDays(1));
            parkingLot.park(vehicle2, LocalDateTime.now().minusDays(1));
        }
        catch (InvalidInputException exception){
            Assert.fail();
        }
    }

    //UnparkingTests
    @Test
    public void testUnparkANeverParkedVehicle(){

        try{
            parkingLot.unpark(1234);
        }
        catch (InvalidInputException exception){
            assertEquals(exception.getMessage(), ErrorConstant.TICKET_NOT_AVAILABLE);
        }

    }

    @Test
    public void testUnparkAnAlreadyUnParkedVehicle(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now());
        parkingLot.unpark(parkingTicket.getTicketNo());
        try{
            parkingLot.unpark(parkingTicket.getTicketNo());
        }
        catch (InvalidInputException exception){
            assertEquals(exception.getMessage(), ErrorConstant.TICKET_NOT_AVAILABLE);
        }

    }

    @Test
    public void testChargesOfHalfHourParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusMinutes(30));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(30), receipt.getFee());

    }

    @Test
    public void testFourHourParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(4));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(60), receipt.getFee());

    }
    @Test
    public void testEightHourParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusMinutes(480));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(60), receipt.getFee());

    }
    @Test
    public void testTwelveHourParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(12));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        //The remaining hours is 0. So 30 + 60 + (1*0) = 90
        assertEquals(Integer.valueOf(90), receipt.getFee());

    }
    @Test
    public void testTwentyFiveHourParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(25));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(90 + 1300), receipt.getFee());

    }

    @Test
    public void testFiveDaysParkedTwoWheeler(){
        IVehicle vehicle1 = new TwoWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusDays(5));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(90 + 10800), receipt.getFee());

    }

    @Test
    public void testChargesOfHalfHourParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusMinutes(30));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(60), receipt.getFee());

    }

    @Test
    public void testFourHourParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(4));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(120), receipt.getFee());

    }
    @Test
    public void testEightHourParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusMinutes(480));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(120), receipt.getFee());

    }
    @Test
    public void testTwelveHourParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(12));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        //The remaining hours is 0. So 60 + 120 + (1*0) = 180
        assertEquals(Integer.valueOf(180), receipt.getFee());

    }
    @Test
    public void testTwentyFiveHourParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusHours(25));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(180 + 2600), receipt.getFee());

    }

    @Test
    public void testFiveDaysParkedFourWheeler(){
        IVehicle vehicle1 = new FourWheeler("TN99J0398");
        ParkingTicket parkingTicket = parkingLot.park(vehicle1, LocalDateTime.now().minusDays(5));
        ParkingReceipt receipt = parkingLot.unpark(parkingTicket.getTicketNo());
        assertEquals(Integer.valueOf(180 + 21600), receipt.getFee());

    }
}