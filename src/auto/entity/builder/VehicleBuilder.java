package auto.entity.builder;

import auto.entity.Bike;
import auto.entity.Car;
import auto.entity.Motobike;
import auto.generator.VehicleGenerator;

public class VehicleBuilder {

    private String model = "Unknown";
    private int maxNumberOfPassengers = 0;
    private double maxSpeed = 1;
    private double momentRentPrice = 100;
    private double oneHourRentPrice = 100;
    private double fuelPricePerKilometer = 100;

    public VehicleBuilder(String model) {
        this.model = model;
    }

    public VehicleBuilder withCapasity(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        return this;
    }

    public VehicleBuilder withMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public VehicleBuilder withMomentRentPrice(double momentRentPrice) {
        this.momentRentPrice = momentRentPrice;
        return this;
    }

    public VehicleBuilder withHourRentPrice(double oneHourRentPrice) {
        this.oneHourRentPrice = oneHourRentPrice;
        return this;
    }

    public VehicleBuilder withFuelPricePerKilometer(double fuelPricePerKilometer) {
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
