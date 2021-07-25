package homework_2.trafficlight;

import java.time.Instant;
import java.util.regex.Pattern;

public class TrafficLight {

    public void run(String secondsAsString) {
        if (isNumber(secondsAsString)) {
            System.out.println("ERROR! Seconds must be a number");
            return;
        }
        long seconds = Long.parseLong(secondsAsString);
        if (seconds < 0) {
            System.out.println("ERROR! The seconds are negative");
            return;
        }
        if (seconds > 86401) {
            System.out.println("ERROR! The seconds are too long");
            return;
        }
        Instant instant = Instant.ofEpochSecond(seconds);
        String fullTime = instant.toString();
        int size = fullTime.length();
        int onlySeconds = Integer.parseInt(fullTime.substring(size - 3, size - 1));
        if (onlySeconds >= 0 && onlySeconds <= 35) {
            System.out.println("Зеленый");
        } else if (onlySeconds >= 40 && onlySeconds <= 55) {
            System.out.println("Красный");
        } else {
            System.out.println("Желтый");
        }
    }

    private boolean isNumber(String str) {
        return Pattern.matches(str, "-?[0-9]+");
    }
}
