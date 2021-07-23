package homework_2.traffic_light;

import homework_2.ConsoleSafeReader;

public class TrafficLight {
    protected static final String RED_COLOUR = "\u001B[31m";
    protected static final String GREEN_COLOUR = "\u001B[32m";
    protected static final String YELLOW_COLOUR = "\u001B[33m";
    protected static final String RESET_COLOUR = "\u001B[0m";

    protected static String greeting = "Enter time in seconds in a range from 0 to 86399";

    public void run() {
        System.out.println(greeting);
        final String input = ConsoleSafeReader.read();
        final String result = processData(input);
        System.out.println(result);
    }

    protected String processData(String input) {
        if (isDigitsAndPositive(input)) {
            final int seconds = Integer.parseInt(input);
            if (seconds > 86399) {
                return "The day is over.";
            } else {
                return showTheLight(seconds);
            }
        } else {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }

    private static boolean isDigitsAndPositive(String str) {
        try {
            int sec = Integer.parseInt(str);
            return sec > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected static String showTheLight(int seconds) {
        seconds %= 60;
        if (seconds < 35) {
            return GREEN_COLOUR + "GREEN" + RESET_COLOUR;
        } else if (seconds < 40 || seconds >= 55) {
            return YELLOW_COLOUR + "YELLOW" + RESET_COLOUR;
        } else {
            return RED_COLOUR + "RED" + RESET_COLOUR;
        }
    }
}
