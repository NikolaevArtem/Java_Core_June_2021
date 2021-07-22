package homework_3;

import java.util.ArrayList;
import java.util.List;

public final class Engine {
    private final String model;
    private final boolean isOk;
    private final int power ;
    private final List<String> spec;

    public Engine(String model, boolean isOk, int power, List<String> spec) {
        this.model = model;
        this.isOk = isOk;
        this.power = power;
        this.spec = new ArrayList<>(spec);
    }

    public Engine() {
        this.model = "Default";
        this.isOk = false;
        this.power = 10;
        this.spec = new ArrayList<>();
    }

    public Engine(String model, int power) {
        this.model = model;
        this.isOk = false;
        this.power = power;
        this.spec = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public boolean isOk() {
        return isOk;
    }

    public int getPower() {
        return power;
    }

    public List<String> getSpec() {
        return spec;
    }

    public Engine getNewEngine(String model, boolean isOk, int power, List<String> spec) {
        return new Engine(model, isOk, power, spec);
    }
}
