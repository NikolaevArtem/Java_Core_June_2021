package homework_2.traffic_light;

import homework_2.ConsoleSafeReader;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class ExtraTrafficLight extends TrafficLight {

    static {
       TrafficLight.greeting = "Enter time in \"hh:mm:ss\" format.";
    }

//    @Override
//    public void run() {
//        System.out.println(greeting);
//        final String input = ConsoleSafeReader.read();
//        final String result = processData(input);
//        System.out.println(result);
//    }

    @Override
    protected String processData(String input) {
        if (isLocalTime(input)) {
            final int seconds = LocalTime.parse(input).toSecondOfDay();
            return showTheLight(seconds);
        } else {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }

    private static boolean isLocalTime(String str) {
        try {
            LocalTime.parse(str);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
