package domain;

public class Courier extends User {
    private String vehicleType;

    public Courier(int userID, int addressID, String firstName, String lastName, String phoneNumber, String vehicleType) {
        super(userID, addressID, firstName, lastName, phoneNumber);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}