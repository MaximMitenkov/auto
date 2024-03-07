package auto.generator;

import auto.entity.*;
import auto.entity.abstractEntity.Vehicle;
import auto.entity.builder.VehicleBuilder;

import java.util.ArrayList;

public class VehicleGenerator {

    private final CustomFaker faker = new CustomFaker();

    private Vehicle generateRandomVehicle() {
        return switch (faker.random().nextInt(1, 5)) {
            case 1 -> generateBike();
            case 2 -> generateMotobike();
            default -> generateCar();
        };
    }

    public RentalPoint generateRentalPoint() {
        RentalPoint rentalPoint = new RentalPoint();
        int numberOfVehicles = faker.random().nextInt(3, 7);
        for (int i = 0; i < numberOfVehicles; i++) {
            rentalPoint.addVehicle(generateRandomVehicle());
        }
        return rentalPoint;
    }

    public ArrayList<RentalPoint> generateRentalPointList(int numberOfPoints) {
        ArrayList<RentalPoint> list = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            list.add(generateRentalPoint());
        }
        return list;
    }

    private Car generateCar() {
        return new VehicleBuilder(faker.customVehicle().carModel())
                .capasity(faker.random().nextInt(2, 6))
                .maxSpeed(faker.random().nextDouble(80, 120))
                .fuelPricePerKilometer(faker.random().nextDouble(15, 50))
                .momentRentPrice(faker.random().nextDouble(300, 700))
                .hourRentPrice(faker.random().nextDouble(100, 250))
                .buildCar();
    }

    private Motobike generateMotobike() {
        return new VehicleBuilder(faker.customVehicle().motobikeModel())
                .capasity(faker.random().nextInt(1, 3))
                .maxSpeed(faker.random().nextDouble(60, 80))
                .fuelPricePerKilometer(faker.random().nextDouble(10, 30))
                .momentRentPrice(faker.random().nextDouble(100, 300))
                .hourRentPrice(faker.random().nextDouble(50, 150))
                .buildMoto();
    }

    private Bike generateBike() {
        return new VehicleBuilder(faker.customVehicle().bikeModel())
                .capasity(faker.random().nextInt(1, 2))
                .maxSpeed(faker.random().nextDouble(20, 55))
                .momentRentPrice(faker.random().nextDouble(50, 100))
                .hourRentPrice(faker.random().nextDouble(10, 30))
                .buildBike();
    }

}
