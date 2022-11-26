package model;

import lombok.Data;
import util.VehicleTypeEnum;

import java.util.LinkedList;

@Data
public class AvailableSpace {

    private final VehicleTypeEnum vehicleType;
    private final LinkedList<Spot> spotList = new LinkedList<>();

    public AvailableSpace(VehicleTypeEnum vehicle, Integer spotSize) {
        this.vehicleType = vehicle;
        for(int i=0;i<spotSize;i++){
            spotList.add(new Spot(i+1));
        }
    }


}
