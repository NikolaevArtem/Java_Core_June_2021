package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

enum LIGHTS {
    GREEN(35),
    YELLOW(40),
    RED(60);

    final int seconds;

    LIGHTS(int seconds) {
        this.seconds = seconds;
    }
}

public class TrafficLight {

    private static boolean isDigits(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

    private static void showTheLight(int seconds) {
        LocalTime time = LocalTime.ofSecondOfDay(seconds);
        seconds %= 60;
        if (seconds < LIGHTS.GREEN.seconds) {
            System.out.println("Green light. Time: " + time);
        } else if (seconds < LIGHTS.YELLOW.seconds) {
            System.out.println("Yellow light. Time: " + time);
        } else if (seconds < LIGHTS.RED.seconds) {
            System.out.println("Red light. Time: " + time);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter time in seconds in a range from 0 to 86399 or in \"HH:MM:SS\" format.");
        System.out.println("\"exit\" - for finish.\n");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Which moment you are interested in?");
                String input = reader.readLine();
                if (isDigits(input) || isLocalTime(input)) {
                    int seconds = isDigits(input) ? Integer.parseInt(input) : LocalTime.parse(input).toSecondOfDay();
                    if (seconds < 0) {
                        System.out.println("Invalid input. Please, enter only positive digits in a range from 0 to 86399.");
                    } else if (seconds > 86399) {
                        System.out.println("Invalid input. The day is over.");
                    } else {
                        showTheLight(seconds);
                    }
                } else {
                    if ("exit".equals(input)) {
                        System.out.println("Bye!");
                        break;
                    } else {
                        System.out.println("Invalid input data. Try again.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
}
