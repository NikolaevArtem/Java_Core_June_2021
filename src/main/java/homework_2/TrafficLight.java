package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    private static String bufferedReaderConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            return "error";
        }
    }

    private static boolean isDigits(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String timeOfDay(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }

    public static void main(String[] args) {

        System.out.println("Enter time in seconds in a range from 0 to 86399. If you are done, enter \"exit\" ");
        while (true) {
            System.out.print("Which second you are interested in?: ");
            String input = bufferedReaderConsole();
            if (isDigits(input)) {
                int seconds = Integer.parseInt(input);
                String timeOfDay = "";
                if (seconds < 0) {
                    System.out.println("Invalid input. Please, enter only positive digits in a range from 0 to 86399.");
                } else if (seconds > 86399) {
                    System.out.println("Invalid input. The day is over.");
                } else {
                    timeOfDay = timeOfDay(seconds);
                    seconds %= 60;
                }
                if (seconds < LIGHTS.GREEN.seconds) {
                    System.out.println("Green light " + timeOfDay);
                } else if (seconds < LIGHTS.YELLOW.seconds) {
                    System.out.println("Yellow light " + timeOfDay);
                } else if (seconds < LIGHTS.RED.seconds) {
                    System.out.println("Red light " + timeOfDay);
                }
            } else {
                if ("exit".equals(input)) {
                    System.out.println("Bye!");
                    break;
                } else if ("error".equals(input)) {
                    System.out.println("Oops... Something went wrong. Let's try again.");
                } else {
                    System.out.println("Invalid input. Please, enter only digits.");
                }
            }
        }
    }
}
