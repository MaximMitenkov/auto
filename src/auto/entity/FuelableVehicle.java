package auto.entity;

import auto.entity.Vehicle;

public abstract class FuelableVehicle extends Vehicle {

    private final double fuelPricePerKilometer;

    public FuelableVehicle(String model,
                    double momentalRentPrice,
                    double oneHourRentPrice,
                    int maxNumberOfPassengers,
                    double maxSpeed,
                    double fuelPricePerKilometer) {
        super(model, momentalRentPrice, oneHourRentPrice, maxNumberOfPassengers, maxSpeed);
        this.fuelPricePerKilometer = fuelPricePerKilometer;
    }

    public double getFuelPricePerKilometer() {
        return fuelPricePerKilometer;
    }

    @Override
    public String printFullInfo() {
        return """
                        Наиболее подходящее вам Т/С
                        
                        Модель: %s
                        Максимальная скорость: %f
                        Количество мест: %d
                        Моментальная цена аренды: %f
                        Цена поездки за 1км: %f
                                
                        """.formatted(getModel(), getMaxSpeed(), getMaxPassengersNumber(),
                getMomentRentPrice(), getFuelPricePerKilometer());
    }

    @Override
    public double getTotalPrice(int distance) {
        return distance * fuelPricePerKilometer + getMomentRentPrice();
    }
}
