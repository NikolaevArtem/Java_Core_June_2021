package homework_2.traffic_light;

public class Main {

    public static void main(String[] args) {
        if (args.length != 0 && args[0].equals("ExtraMode")) {
            new TrafficLightExtraMode().run();
        } else {
            new TrafficLight().run();
        }
    }
}
