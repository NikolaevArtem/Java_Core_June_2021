package homework_2.traffic_light;

import static homework_2.traffic_light.utils.Utils.isExtraMode;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = args.length > 0 && isExtraMode(args[0]) ? new TrafficLightExtraMode() : new TrafficLight();
        trafficLight.run();
    }
}
