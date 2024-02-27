package auto.entity;

public class Car extends FuelableVehicle {
    public Car(String model,
               double rentPrice,
               double oneHourRentPrice,
               int maxNumberOfPassengers,
               double maxSpeed,
               double fuelPricePerKilometer) {
        super(model, rentPrice,oneHourRentPrice, maxNumberOfPassengers, maxSpeed, fuelPricePerKilometer);
    }
}
