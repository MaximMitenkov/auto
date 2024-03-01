package auto.menu;

import auto.entity.*;
import net.datafaker.Faker;

import java.util.Scanner;

public class Menu {

    protected static final String INPUT_DATA_FORMAT = "dd MM yyyy";
    protected static final String OUTPUT_DATA_FORMAT = "dd-MM-yyyy";
    private int budget, numberOfPassengers, distance;

    private final Vehicle bike = new Bike("BMX",
            100, 10, 1, 25);
    private final Vehicle truck = new Car("Ford Transit",
            500, 100, 8, 100, 150);
    private final Vehicle car = new Car("VAZ-2104",
            400, 80,
            4,
            120,
            100);
    private final Vehicle motocycle = new Motobike("Ural",
            300, 50, 2, 80, 50);

    protected VehicleList vehicles = new VehicleList(bike, truck, car, motocycle);

    public void start() {
        VehicleManager vehicleManager = new VehicleManager(vehicles);

        Scanner in = new Scanner(System.in);
        boolean doCycle = true;

        fillInTravelData();

        Faker faker = new Faker();
        String randomName = faker.name().fullName().toUpperCase();
        String randomCar = vehicles.getVehicleById(faker.number().numberBetween(0, vehicles.getLength())).getModel();

        while (doCycle) {
            System.out.printf("""
                    Прошлый красавчик %s
                    Уже забрал свой %s
                    Выбирай и ты!%n
                    """, randomName, randomCar);
            System.out.println("\n\n\nВыберите нужную функцию");
            System.out.println("""
                    1) Показать список всех автомобилей
                    2) Рассчитать оптимальный вариант для поездки
                    3) Показать список доступных автомобилей для поездки
                    4) Обновить данные о поездке
                    5) Взять автомобиль в аренду на определенное время
                    
                    0) Выйти из программы
                    """);


            int choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1:
                    vehicles.show();
                    in.nextLine();
                    break;
                case 2:
                    vehicles.printBestVariant(numberOfPassengers, budget, distance);
                    System.out.println();
                    break;
                case 3:
                    vehicles.show(vehicles.sortPossibleVehicles(numberOfPassengers, budget, distance));
                    in.nextLine();
                    break;
                case 4:
                    fillInTravelData();
                    in.nextLine();
                    break;
                case 5:
                    vehicleManager.holdVehicle(vehicleManager.chooseVehicle());
                    break;
                case 0:
                    doCycle = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void fillInTravelData() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество человек для поездки");
        numberOfPassengers = Integer.parseInt(in.nextLine());

        System.out.println("Введите ваш бюджет");
        budget = Integer.parseInt(in.nextLine());

        System.out.println("Введите предполагаемую длину пути");
        distance = Integer.parseInt(in.nextLine());

        System.out.println("Данные успешно записаны");
    }
}
