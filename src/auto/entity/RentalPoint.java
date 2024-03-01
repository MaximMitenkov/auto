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

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void show() {
        System.out.println("You are welcome to Rental Point at " + address + "\n Here is our vehicles list!\n\n");
        vehicles.show();
    }

    private void generateRandomVehicle(Faker faker, Random random) {
        switch (random.nextInt(1,3)) {
            case 1: vehicles.add(new Car(
                    faker.vehicle().model(),
                    random.nextDouble(500, 1000),
                    random.nextDouble(100, 200),
                    faker.number().numberBetween(2,4),
                    random.nextDouble(60, 120),
                    random.nextDouble(20,60)));
        }
    }

}
