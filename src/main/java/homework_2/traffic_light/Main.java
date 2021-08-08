package homework_2.traffic_light;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Only 1 parameter is allowed");
        } else if (args.length == 0) {
            new TrafficLight().run();
        } else if (args[0].equals("ExtraMode")) {
            new ExtraTrafficLight().run();
        }
    }
}