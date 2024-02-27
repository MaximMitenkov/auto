package auto.entity;

import auto.Printable;

import java.time.*;

public abstract class Vehicle implements Printable {

    private final String model;
    private final int maxNumberOfPassengers;
    private final double maxSpeed;
    private final double momentRentPrice;
    private final double oneHourRentPrice;

    public Vehicle(String model,
                   double momentRentPrice,
                   double oneHourRentPrice,
                   int maxNumberOfPassengers,
                   double maxSpeed) {
        this.model = model;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.maxSpeed = maxSpeed;
        this.momentRentPrice = momentRentPrice;
        this.oneHourRentPrice = oneHourRentPrice;
    }

    public String getModel() {
        return model;
    }
    public int getMaxPassengersNumber() {
        return maxNumberOfPassengers;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public double getMomentRentPrice() {
        return momentRentPrice;
    }

    @Override
    public String printFullInfo() {

        return """
                        Наиболее подходящее вам Т/С
                        
                        Модель: %s
                        Максимальная скорость: %f
                        Количество мест: %d
                        Моментальная цена аренды: %f
                        
                        """.formatted(getModel(), getMaxSpeed(), getMaxPassengersNumber(),
                getMomentRentPrice());
    }

    @Override
    public String printShortInfo() {
        return "%s цена %f\n".formatted(model, momentRentPrice);
    }

    public double getTotalPrice(int distance) {
        return momentRentPrice;
    }

    public double getTotalPrice(LocalDate dateUntilRented) {
        LocalDateTime time = dateUntilRented.atTime(LocalTime.now());
        Duration rentDuration = Duration.between(LocalDateTime.now(), time);
        return rentDuration.toHours() * oneHourRentPrice * 0.75;
    }

    public double calculatePriceAsHours(Duration duration) {
        if (duration.toDays() > 0) {
            return duration.toHours() * oneHourRentPrice;
        }
        return duration.toHours() * oneHourRentPrice + momentRentPrice;
    }

    public double getTotalTime(int distance) {
        return distance / getMaxSpeed();
    }

    public double getOneHourRentPrice() {
        return oneHourRentPrice;
    }
}
