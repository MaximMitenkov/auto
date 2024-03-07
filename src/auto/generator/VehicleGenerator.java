package auto.generator;

import auto.entity.*;
import auto.entity.abstractEntity.Vehicle;
import auto.entity.builder.VehicleBuilder;

import java.util.ArrayList;
import java.util.Random;

public class VehicleGenerator {

    private final CustomFaker faker = new CustomFaker();
    private final Random random = new Random();

    private Vehicle generateRandomVehicle() {
        return switch (random.nextInt(1, 5)) {
            case 1 -> generateBike();
            case 2 -> generateMotobike();
            default -> generateCar();
        };
    }

    public RentalPoint generateEmptyRentalPoint() {
        return new RentalPoint(new VehicleList(), faker.address().streetAddressNumber());
    }

    public RentalPoint generateRentalPoint() {
        RentalPoint rentalPoint = new RentalPoint();
        for (int i = 0; i < random.nextInt(3,7); i++) {
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
                .withCapasity(random.nextInt(2, 6))
                .withMaxSpeed(random.nextDouble(80, 120))
                .withFuelPricePerKilometer(random.nextDouble(15, 50))
                .withMomentRentPrice(random.nextDouble(300, 700))
                .withHourRentPrice(random.nextDouble(100, 250))
                .buildCar();
    }

    private Motobike generateMotobike() {
        return new VehicleBuilder(faker.customVehicle().motobikeModel())
                .withCapasity(random.nextInt(1, 3))
                .withMaxSpeed(random.nextDouble(60, 80))
                .withFuelPricePerKilometer(random.nextDouble(10, 30))
                .withMomentRentPrice(random.nextDouble(100, 300))
                .withHourRentPrice(random.nextDouble(50, 150))
                .buildMoto();
    }

    private Bike generateBike() {
        return new VehicleBuilder(faker.customVehicle().bikeModel())
                .withCapasity(random.nextInt(1, 2))
                .withMaxSpeed(random.nextDouble(20, 55))
                .withMomentRentPrice(random.nextDouble(50, 100))
                .withHourRentPrice(random.nextDouble(10, 30))
                .buildBike();
    }

}
