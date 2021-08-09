package homework_2.traffic_light;

import java.time.Instant;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TrafficLight {

    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String DAY_OVER = "The day is over";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String secondsAsString = scanner.next();
        if (isNumber(secondsAsString)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        long seconds = Long.parseLong(secondsAsString);
        if (seconds < 0) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (seconds > 86399) {
            System.out.println(DAY_OVER);
            return;
        }
        Instant instant = Instant.ofEpochSecond(seconds);
        String fullTime = instant.toString();
        int size = fullTime.length();
        int onlySeconds = Integer.parseInt(fullTime.substring(size - 3, size - 1));
        if (onlySeconds >= 0 && onlySeconds < 35) {
            System.out.println("Green");
        } else if (onlySeconds >= 40 && onlySeconds < 55) {
            System.out.println("Red");
        } else {
            System.out.println("Yellow");
        }
    }

    private boolean isNumber(String str) {
        return !Pattern.matches( "[0-9]+", str);
    }
}
