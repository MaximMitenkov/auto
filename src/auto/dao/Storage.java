package auto.dao;

import auto.entity.RentalPoint;

import java.util.*;

public class Storage {
    private final Map<Integer, RentalPoint> rentalPoints = new HashMap<Integer, RentalPoint>();
    private int counter;

    public Storage(RentalPoint... rentalPoints) {
        this.counter = 0;
        Arrays.asList(rentalPoints).forEach((a) -> Storage.this.rentalPoints.put(counter++, a));
    }

    public RentalPoint getRentalPointById(int index) {
        return rentalPoints.get(index);
    }

    public Integer add(RentalPoint rentalPoint) {
        this.rentalPoints.put(counter, rentalPoint);
        return counter++;
    }
}
