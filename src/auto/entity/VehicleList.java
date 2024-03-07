package auto.entity;

import auto.entity.abstractEntity.FuelableVehicle;
import auto.entity.abstractEntity.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

public class VehicleList {

    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    public VehicleList(Vehicle... vehicles) {
        this.vehicles.addAll(Arrays.asList(vehicles));
    }
    public Vehicle getVehicleById(int id) {
        return vehicles.get(id);
    }

    public int getLength() {
        return vehicles.toArray().length;
    }
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void show() {
        show(this.vehicles);
    }

    public void show(ArrayList<Vehicle> vehicles) {
        vehicles.forEach(Vehicle::printShortInfo);
    }

    public void showWithId() {
        for (int i = 0; i < vehicles.size(); i++ ) {
            System.out.println(i + " " +vehicles.get(i).printShortInfo());
        }
    }


    public Vehicle findBestVariant(int numberOfPeople, int budget, int distance) {
        ArrayList<Vehicle> variants = checkPossibleVariants(numberOfPeople, budget, distance);
        if (variants.isEmpty()) {
            return null;
        }
        return chooseBestVariant(variants, distance);
    }

    public ArrayList<Vehicle> sortPossibleVehicles(int numberOfPeople, int budget, int distance) {
        ArrayList<Vehicle> variants = checkPossibleVariants(numberOfPeople, budget, distance);
        variants.sort((a, b) -> {
            Double timeA = a.getTotalTime(distance);
            Double timeB = b.getTotalTime(distance);
            if (timeA.equals(timeB))
                return Double.compare(a.getTotalPrice(distance),(b.getTotalPrice(distance)));
            else
                return timeA.compareTo(timeB);
        });
        //variants.sort(new VehicleComparator(distance));
        return variants;
    }

    public void printBestVariant(int numberOfPeople, int budget, int distance){
        Vehicle best = findBestVariant(numberOfPeople, budget, distance);
        if (best == null) {
            System.out.println("Вам ничего не подходит");
            return;
        }
        System.out.println(best.printFullInfo());
    }

    private ArrayList<Vehicle> checkPossibleVariants (int numberOfPeople, int budget, int distance) {
        ArrayList<Vehicle> variants = vehicles;

        variants.removeIf(a -> {
            if (a.getMaxPassengersNumber() < numberOfPeople)
                return true;
            if (a instanceof FuelableVehicle fuelableVehicle)
                return fuelableVehicle.getTotalPrice(distance) > budget;
            return false;
        });
        return variants;
    }

    private Vehicle chooseBestVariant(ArrayList<Vehicle> variants, double distance) {
        if (variants.isEmpty()) {
            return null;
        }

        double bestTime = 0;
        Vehicle bestVariant = null;
        for (Vehicle vehicle : variants) {
            if (bestTime == 0 || distance / vehicle.getMaxSpeed() < bestTime) {
                bestTime = distance / vehicle.getMaxSpeed();
                bestVariant = vehicle;
            }
        }
        return bestVariant;
    }
}
