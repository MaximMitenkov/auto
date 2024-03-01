package auto.entity;

import net.datafaker.Faker;

import java.util.Random;

public class RentalPoint {

    private final String address;
    private final VehicleList vehicles;

    public RentalPoint(VehicleList localVehicles, String address) {
        this.vehicles = localVehicles;
        this.address = address;
    }

    public RentalPoint() {
        Faker faker = new Faker();
        Random random = new Random();
        this.address = faker.address().fullAddress();
        this.vehicles = new VehicleList();
    }

    public VehicleList getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void show() {
        System.out.println("You are welcome to Rental Point at " + address + "\n Here is our vehicles list!\n\n");
        vehicles.show();
    }

    public void showAddress() {
        System.out.println(address);
    }

    public void showAddress(int id) {
        System.out.println(id + "    " + address);
    }

}
