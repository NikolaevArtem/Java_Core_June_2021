package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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
        if (seconds < 35) {
            System.out.println("\u001B[32m" + "Green light." + "\u001B[0m" + " Time: " + time);
        } else if (seconds < 40 || seconds >= 55) {
            System.out.println("\u001B[33m" + "Yellow light." + "\u001B[0m" + " Time: " + time);
        } else {
            System.out.println("\u001B[31m" + "Red light." + "\u001B[0m" + " Time: " + time);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter time in seconds in a range from 0 to 86399 or in \"hh:mm:ss\" format.");
        System.out.println("Type \"exit\" without quotes to exit.\n");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Which moment you are interested in?");
                String input = reader.readLine();
                if (isDigits(input) || isLocalTime(input)) {
                    int seconds = isDigits(input) ?
                            Integer.parseInt(input) :
                            LocalTime.parse(input).toSecondOfDay();
                    if (seconds > 86399 || seconds < 0) {
                        String message = seconds > 86399 ?
                                " The day is over." :
                                " Please, enter only positive digits in a range from 0 to 86399.";
                        System.out.println("Invalid input." + message);
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
