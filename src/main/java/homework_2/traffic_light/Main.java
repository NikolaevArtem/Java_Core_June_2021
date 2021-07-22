package homework_2.traffic_light;

import static homework_2.traffic_light.utils.Utils.isExtraMode;

public class Main {
    public static void main(String[] args) {
        int mode = args.length > 0 && isExtraMode(args[0]) ? 1 : 0;
        new TrafficLight(mode).start();
    }
}
