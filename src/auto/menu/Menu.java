package auto.menu;

import auto.dao.Storage;
import auto.entity.*;
import net.datafaker.Faker;

import java.util.Scanner;

public class Menu {

    protected static final String INPUT_DATA_FORMAT = "dd MM yyyy";
    protected static final String OUTPUT_DATA_FORMAT = "dd-MM-yyyy";
    private int budget, numberOfPassengers, distance;
    private final Storage storage;

    protected VehicleList vehicles = new VehicleList();
    private final VehicleManager vehicleManager = new VehicleManager(null);

    public Menu(Storage storage) {
        this.storage = storage;
    }

    public void start() {

        chooseRentalPoint();

        Scanner in = new Scanner(System.in);
        boolean doCycle = true;

        fillInTravelData();

        Faker faker = new Faker();
        String randomName = faker.name().fullName().toUpperCase();
        String randomCar = faker.vehicle().model();

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

            //TODO сделать свич красивее
            switch (choice) {
                case 1:
                    vehicles.showWithId();
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
                case 6:
                    vehicles = chooseRentalPoint().getVehicles();
                    break;
                case 0:
                    doCycle = false;
                    break;
                default:
                    break;
            }
        }
    }

    //TODO Вынести в класс авторизации
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

    private RentalPoint chooseRentalPoint() {
        System.out.println("Выберите ближайшую к вам точку аренды, чтобы посмотреть доступный транспорт");
        storage.showPresentation();
        Scanner in = new Scanner(System.in);
        int i = Integer.parseInt(in.nextLine());
        vehicles = storage.getRentalPointById(i).getVehicles();
        vehicleManager.setVehicles(vehicles);
        return storage.getRentalPointById(i);
    }
}
