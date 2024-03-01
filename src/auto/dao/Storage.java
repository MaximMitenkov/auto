package auto.dao;

import auto.entity.RentalPoint;

import java.util.*;

public class Storage {
    private final Map<Integer, RentalPoint> rentalPoints = new HashMap<>();
    private int counter;

    public Storage(ArrayList<RentalPoint> rentalPoints) {
        this.counter = 0;
        rentalPoints.forEach((a) -> Storage.this.rentalPoints.put(counter++, a));
    }

    public RentalPoint getRentalPointById(int index) {
        return rentalPoints.get(index);
    }

    public Integer add(RentalPoint rentalPoint) {
        this.rentalPoints.put(counter, rentalPoint);
        return counter++;
    }

    //TODO нужно убрать из DAO всё, кроме операций с данными
    public void showPresentation() {
        rentalPoints.forEach((a, b) -> b.showAddress(a));
    }
}
