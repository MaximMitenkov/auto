package auto.entity;

import auto.entity.abstractEntity.Vehicle;

import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle> {

    private Integer distance;

    public VehicleComparator(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        Double time1 = o1.getTotalTime(distance);
        Double time2 = o2.getTotalTime(distance);
        int comparatorDecision = time1.compareTo(time2);
        if (comparatorDecision == 0) {
            Double price1 = o1.getTotalPrice(distance);
            Double price2 = o2.getTotalPrice(distance);
            comparatorDecision = price1.compareTo(price2);
        }
        return comparatorDecision;
    }

}
