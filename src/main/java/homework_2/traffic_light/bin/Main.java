package homework_2.traffic_light.bin;

import homework_2.traffic_light.sources.ExtraTrafficLight;
import homework_2.traffic_light.sources.TrafficLight;

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
