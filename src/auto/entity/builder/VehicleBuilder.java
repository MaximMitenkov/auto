package auto.entity.builder;

import auto.entity.Bike;
import auto.entity.Car;
import auto.entity.Motobike;

public class VehicleBuilder {

    private final String model;
    private int maxNumberOfPassengers = 0;
    private double maxSpeed = 1;
    private double momentRentPrice = 100;
    private double oneHourRentPrice = 100;
    private double fuelPricePerKilometer = 100;

    public VehicleBuilder(String model) {
        this.model = model;
    }

    public VehicleBuilder capasity(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        return this;
    }

    public VehicleBuilder maxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public VehicleBuilder momentRentPrice(double momentRentPrice) {
        this.momentRentPrice = momentRentPrice;
        return this;
    }

    public VehicleBuilder hourRentPrice(double oneHourRentPrice) {
        this.oneHourRentPrice = oneHourRentPrice;
        return this;
    }

    public VehicleBuilder fuelPricePerKilometer(double fuelPricePerKilometer) {
        this.fuelPricePerKilometer = fuelPricePerKilometer;
        return this;
    }

    public Car buildCar() {
        return new Car(
                this.model,
                this.momentRentPrice,
                this.oneHourRentPrice,
                this.maxNumberOfPassengers,
                this.maxSpeed,
                this.fuelPricePerKilometer);
    }

    public Motobike buildMoto() {
        return new Motobike(
                this.model,
                this.momentRentPrice,
                this.oneHourRentPrice,
                this.maxNumberOfPassengers,
                this.maxSpeed,
                this.fuelPricePerKilometer);
    }

    public Bike buildBike() {
        return  new Bike(
                this.model,
                this.momentRentPrice,
                this.oneHourRentPrice,
                this.maxNumberOfPassengers,
                this.maxSpeed);
    }

}
