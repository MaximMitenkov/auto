package auto;

import auto.dao.Storage;
import auto.generator.VehicleGenerator;
import auto.menu.Menu;

public class Main {

    public static void main(String[] args) {
        VehicleGenerator generator = new VehicleGenerator();
        Storage storage = new Storage(generator.generateRentalPointList(3));
        Menu menu = new Menu(storage);
        menu.start(); //запустить программу
    }

}
