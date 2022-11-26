package util;

public enum VehicleEnum {

    scooter(Constants.TWO_WHEELER),
    motorcycle(Constants.TWO_WHEELER),
    car(Constants.FOUR_WHEELER),
    SUV(Constants.FOUR_WHEELER),
    truck(Constants.HEAVY_VEHICLE),
    bus(Constants.HEAVY_VEHICLE);

    private final String vehicleType;

    VehicleEnum(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }


}
