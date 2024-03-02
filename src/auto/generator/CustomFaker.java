package auto.generator;

import net.datafaker.Faker;

public class CustomFaker extends Faker {
    public ModelVehicle customVehicle() {
        return getProvider(ModelVehicle.class, ModelVehicle::new, this);
    }
}
