package model.feemodels;

import exception.InvalidInputException;
import model.mall.MallParkingLotFactory;
import timeblocks.*;
import util.ErrorConstant;
import util.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: Need to make this class as singleton
public class FeeModelFactory {

    private List<TimeBlock> airportTimeBlocks = new ArrayList<>();
    private List<TimeBlock> stadiumTimeBlocks = new ArrayList<>();
    private List<TimeBlock> cityMarketTimeBlocks = new ArrayList<>();

    public FeeModelFactory() {
        setAirportTimeblocks();
        setStadiumTimeblocks();
        setCityMarketTimeblocks();
    }

    IFeeModel airportFeeModel = new AirportFeeModelImpl(new TimeBlockFactory(airportTimeBlocks));
    IFeeModel mallFeeModel = new MallFeeModelImpl(new MallParkingLotFactory());
    IFeeModel statiumFeeModel = new StadiumFeeModelImpl(new TimeBlockFactory(stadiumTimeBlocks));
    IFeeModel cityMarketFeeModel = new CityMarketFeeModelImpl(new TimeBlockFactory(cityMarketTimeBlocks));

    public IFeeModel getFeeModelImpl(FeeModelEnum feeModelEnum){
        switch (feeModelEnum){
            case AIRPORT: return airportFeeModel;
            case MALL: return mallFeeModel;
            case STADIUM: return statiumFeeModel;
            case CITY_MARKET: return cityMarketFeeModel;
            default: throw new InvalidInputException(ErrorConstant.FEE_MODEL_DO_NOT_EXIST);
        }
    }

    private void setCityMarketTimeblocks() {
        //City Market Timeblocks
        RegularTimeblock twRegularTimeblock = new RegularTimeblock(0L, 3L, 20, VehicleTypeEnum.TwoWheeler);
        EachHourPostRegularBlockForOneDay eachHourPostRegularBlockForOneDay
                = new EachHourPostRegularBlockForOneDay(3L, 24L, 10, VehicleTypeEnum.TwoWheeler,
                Arrays.asList(twRegularTimeblock));
        EachDayForFiveDaysTimeblock eachDayForFiveDaysTimeblock
                = new EachDayForFiveDaysTimeblock(24L, 24*5, 100, VehicleTypeEnum.TwoWheeler,
                Arrays.asList( eachHourPostRegularBlockForOneDay));
        TimeBlock eachDayAfter5DaysTimeBlock
                = new EachDayForFiveDaysTimeblock(24*5, 1440, 2500, VehicleTypeEnum.TwoWheeler,
                Arrays.asList(  eachDayForFiveDaysTimeblock));

        List<TimeBlock> cityMarketTWBlocks = Arrays.asList(
                twRegularTimeblock,
                eachHourPostRegularBlockForOneDay,
                eachDayForFiveDaysTimeblock,
                eachDayAfter5DaysTimeBlock);

        RegularTimeblock fwRegularTimeblock = new RegularTimeblock(0L, 3L, 40, VehicleTypeEnum.FourWheeler);
        EachHourPostRegularBlockForOneDay eachHourPostRegularBlockForOneDayFW
                = new EachHourPostRegularBlockForOneDay(3L, 24L, 20, VehicleTypeEnum.FourWheeler,
                Arrays.asList(twRegularTimeblock));
        EachDayForFiveDaysTimeblock eachDayForFiveDaysTimeblockFW
                = new EachDayForFiveDaysTimeblock(24L, 24*5, 200, VehicleTypeEnum.FourWheeler,
                Arrays.asList(twRegularTimeblock, eachHourPostRegularBlockForOneDay));
        TimeBlock eachDayAfter5DaysTimeBlockFW
                = new EachDayForFiveDaysTimeblock(24*5, 1440, 5000, VehicleTypeEnum.FourWheeler,
                Arrays.asList(twRegularTimeblock, eachHourPostRegularBlockForOneDay, eachDayForFiveDaysTimeblock));

        List<TimeBlock> cityMarketFWBlocks = Arrays.asList(
                fwRegularTimeblock,
                eachHourPostRegularBlockForOneDayFW,
                eachDayForFiveDaysTimeblockFW,
                eachDayAfter5DaysTimeBlockFW);

        cityMarketTimeBlocks.addAll(cityMarketTWBlocks);
        cityMarketTimeBlocks.addAll(cityMarketFWBlocks);
    }

    private void setStadiumTimeblocks() {
        //Stadium Timeblocks
        List<TimeBlock> stadiumRegularTWBlocks = Arrays.asList(
                new RegularTimeblock(0L, 4L, 30, VehicleTypeEnum.TwoWheeler),
                new RegularTimeblock(4L, 12L, 60, VehicleTypeEnum.TwoWheeler));
        List<TimeBlock> stadiumTWBlocks = new ArrayList<>();
        stadiumTWBlocks.addAll(stadiumRegularTWBlocks);
        stadiumTWBlocks.add(new EachHourTimeblock(12L, 1440L, 100, VehicleTypeEnum.TwoWheeler, stadiumRegularTWBlocks));

        List<TimeBlock> stadiumRegularFWBlocks = Arrays.asList(
                new RegularTimeblock(0L, 4L, 60, VehicleTypeEnum.FourWheeler),
                new RegularTimeblock(4L, 12L, 120, VehicleTypeEnum.FourWheeler));
        List<TimeBlock> stadiumFWBlocks = new ArrayList<>();
        stadiumFWBlocks.addAll(stadiumRegularFWBlocks);
        stadiumFWBlocks.add(new EachHourTimeblock(12L, 1440L, 200, VehicleTypeEnum.FourWheeler, stadiumRegularFWBlocks));
        stadiumTimeBlocks.addAll(stadiumFWBlocks);
        stadiumTimeBlocks.addAll(stadiumTWBlocks);
    }

    private void setAirportTimeblocks() {
        //Airport Timeblocks
        List<TimeBlock> airportTWBlocks = Arrays.asList(
                new RegularTimeblock(0L, 1L, 0, VehicleTypeEnum.TwoWheeler),
                new RegularTimeblock(1L, 8L, 40, VehicleTypeEnum.TwoWheeler),
                new RegularTimeblock(8L, 24L, 60, VehicleTypeEnum.TwoWheeler),
                new EachDayTimeblock(24L, 1440L, 80, VehicleTypeEnum.TwoWheeler));

        List<TimeBlock> airportFWBlocks = Arrays.asList(
                new RegularTimeblock(0L, 12L, 60, VehicleTypeEnum.FourWheeler),
                new RegularTimeblock(12L, 24L, 80, VehicleTypeEnum.FourWheeler),
                new EachDayTimeblock(24L, 1440L, 100, VehicleTypeEnum.FourWheeler));
        airportTimeBlocks.addAll(airportTWBlocks);
        airportTimeBlocks.addAll(airportFWBlocks);
    }
}
