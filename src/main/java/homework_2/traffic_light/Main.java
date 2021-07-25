package homework_2.traffic_light;

public class Main {
    public static void main(String[] args) {
        if (args[0].equals("ExtraMode")) {
            new ExtraTrafficLight().run();
        } else {
            new TrafficLight().run();
        }
    }
}
