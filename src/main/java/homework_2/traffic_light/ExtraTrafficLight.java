package homework_2.traffic_light;

import homework_2.ConsoleSafeReader;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class ExtraTrafficLight extends TrafficLight {

    static {
       TrafficLight.greeting = "Enter time in seconds in a range from 0 to 86399 or time in \"hh:mm:ss\" format.";
    }

    @Override
    protected String processData(String input) {
        if (isLocalTime(input) || isDigitsAndPositive(input)) {
            final int seconds = isLocalTime(input) ?
                    LocalTime.parse(input).toSecondOfDay() :
                    Integer.parseInt(input);
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
