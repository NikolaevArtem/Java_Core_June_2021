package homework_2.trafficLight;

import java.io.IOException;

public class TrafficLight {
    public static void main(String[] args) throws IOException {
        Strategy strategy = new Strategy();
        strategy.choosingStrategy();
    }
}
