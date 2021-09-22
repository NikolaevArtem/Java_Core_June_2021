package homework_2.traffic_light;

/*
Traffic Lights App

you can use 'now' argument to get result for the current time ;)
java Main -now

 */

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            new TrafficLight().run();
        } else {
            new ExtraTrafficLight().run(args[0]);
        }
    }
}
