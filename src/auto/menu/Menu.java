package auto.menu;

import auto.entity.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public final String INPUT_DATA_FORMAT = "dd MM yyyy";
    public final String OUTPUT_DATA_FORMAT = "dd-MM-yyyy";
    private int budget, numberOfPassengers, distance;

    Vehicle bike = new Bike("BMX",
            100, 10, 1, 25);
    Vehicle truck = new Car("Ford Transit",
            500, 100, 8, 100, 150);
    Vehicle car = new Car("VAZ-2104",
            400, 80,
            4,
            120,
            100);
    Vehicle motocycle = new Motobike("Ural",
            300, 50, 2, 80, 50);

    VehicleList vehicles = new VehicleList();
    public void start() {
        vehicles.add(truck, car, motocycle, bike);

        Scanner in = new Scanner(System.in);
        boolean doCycle = true;

        fillInTravelData(); // кажется лишнее, раз меню есть ниже

        while (doCycle) {
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
                    holdVehicle(chooseVehicle());
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

    private void holdVehicle(Vehicle vehicle) {

        System.out.println("""
                1) Указать дату до которой планируется взять т/с в аренду
                2) Взять т/с на сутки
                3) Взять т/с на 12 часов
                4) Указать количество часов, на которое планируется взять т/с
                """);
        Scanner in = new Scanner(System.in);
        switch (Integer.parseInt(in.nextLine())) {
            case 1:
                System.out.println("Введите дату, формат ввода даты 'DD mm YYYY'");
                LocalDate date = LocalDate.parse(in.nextLine(), DateTimeFormatter.ofPattern(INPUT_DATA_FORMAT));
                int price = (int) vehicle.getTotalPrice(date);
                System.out.printf("В таком случае, вы заплатите за аренду %d денег%n", price);
                System.out.println(date.format(DateTimeFormatter.ofPattern(OUTPUT_DATA_FORMAT)));
                break;
            case 2:
                System.out.println("Это будет вам стоить " +
                        vehicle.getOneHourRentPrice() * 16 + vehicle.getMomentRentPrice());
                break;
            case 3:
                System.out.println("Это будет вам стоить " +
                        (vehicle.getOneHourRentPrice() * 12 + vehicle.getMomentRentPrice()));
                break;
            case 4:
                System.out.println("Введите количество часов для аренды");
                double priceHours = vehicle.calculatePriceAsHours(Duration.ofHours(Integer.parseInt(in.nextLine())));
                System.out.println("Вам будет это стоить " + priceHours);
            default: break;
        }
    }

    private Vehicle chooseVehicle() {
        Scanner in = new Scanner(System.in);
        vehicles.showWithId();
        System.out.println("Напишите номер выбранного вами транспорта");

        return vehicles.getVehicleById(Integer.parseInt(in.nextLine()));
    }
}
