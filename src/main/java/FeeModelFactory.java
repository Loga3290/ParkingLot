import exception.InvalidInputException;
import model.AirportFeeModelImpl;
import model.IFeeModel;
import model.MallFeeModelImpl;
import model.StadiumFeeModelImpl;
import model.airport.AirportParkingLotFactory;
import model.mall.MallParkingLotFactory;
import model.stadium.StadiumParkingLotFactory;
import util.ErrorConstant;

public class FeeModelFactory {

    IFeeModel airportFeeModel = new AirportFeeModelImpl(new AirportParkingLotFactory());
    IFeeModel mallFeeModel = new MallFeeModelImpl(new MallParkingLotFactory());
    IFeeModel statiumFeeModel = new StadiumFeeModelImpl(new StadiumParkingLotFactory());

    public IFeeModel getFeeModelImpl(FeeModelEnum feeModelEnum){
        switch (feeModelEnum){
            case AIRPORT: return airportFeeModel;
            case MALL: return mallFeeModel;
            case STADIUM: return statiumFeeModel;
            default: throw new InvalidInputException(ErrorConstant.FEE_MODEL_DO_NOT_EXIST);
        }
    }
}
