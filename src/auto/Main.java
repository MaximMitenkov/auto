package auto;

import auto.dao.Storage;
import auto.generator.VehicleGenerator;
import auto.menu.Menu;
import net.datafaker.Faker;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        VehicleGenerator generator = new VehicleGenerator(new Faker(), new Random());
        Storage storage = new Storage(generator.generateRentalPointList(3));
        Menu menu = new Menu(storage);
        menu.start(); //запустить программу
    }

}
