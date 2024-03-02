package auto.generator;

import net.datafaker.Faker;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

public class ModelVehicle extends AbstractProvider<BaseProviders> {
    public static final String[] CAR_MODELS = {
            "Ford Transit", "VAZ-2104", "Lancer", "UAZik", "LADA Granta", "LADA Vesta"};
    public static final String[] MOTOBIKE_MODELS = {"Ural", "Moped", "Chumahod", "Izh", "Chopper"};
    public static final String[] BIKE_MODELS = {"BMX", "Aist", "Stells Challenger", "Stells Navigator"};

    public ModelVehicle(BaseProviders faker) {
        super(faker);
    }

    public String carModel() {
        return CAR_MODELS[faker.number().numberBetween(0, CAR_MODELS.length)];
    }

    public String motobikeModel() {
        return MOTOBIKE_MODELS[faker.number().numberBetween(0, CAR_MODELS.length)];
    }

    public String bikeModel() {
        return BIKE_MODELS[faker.number().numberBetween(0, CAR_MODELS.length)];
    }

}
