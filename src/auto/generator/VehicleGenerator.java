package auto.generator;

import auto.entity.*;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class VehicleGenerator {

    private final Faker faker = new Faker();
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

    //TODO добавить свои листы с машинами
    private Car generateCar() {
        return new Car(
                faker.vehicle().model(),
                random.nextDouble(500, 1000),
                random.nextDouble(100, 200),
                faker.number().numberBetween(2,4),
                random.nextDouble(60, 120),
                random.nextDouble(20,60));
    }

    private Motobike generateMotobike() {
        return new Motobike(
                faker.vehicle().model(),
                random.nextDouble(300, 600),
                random.nextDouble(50, 150),
                faker.number().numberBetween(1,3),
                random.nextDouble(60, 100),
                random.nextDouble(20,60));
    }

    private Bike generateBike() {
        return new Bike(
                faker.vehicle().model(),
                random.nextDouble(100, 150),
                random.nextDouble(5, 15),
                faker.number().numberBetween(1,2),
                random.nextDouble(25, 50));
    }

}
