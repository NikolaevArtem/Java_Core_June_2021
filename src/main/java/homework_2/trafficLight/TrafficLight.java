package homework_2.trafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private final String ANSI_RESET = "\u001b[0m";

    private final String ANSI_RED = "\u001B[31m";

    public final String ANSI_GREEN = "\u001B[32m";

    private final String ANSI_YELLOW = "\u001B[33m";

    private final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    private int seconds;

    public void runSecondsFormat() {
        System.out.println("Enter necessary amount of seconds.");
        String input = consoleReader();
        if(!isDigit(input)) {
            System.out.println(ERROR);
            return;
        }
        seconds = Integer.parseInt(input);
        if (isNegative(seconds)) {
            System.out.println(ERROR);
            return;
        }
        if (!dayOverCheck(seconds)) {
            System.out.println("Day is over");
            return;
        }
        trafficLightColorDetection(seconds);
    }

    public void runTimeFormat() {
        System.out.println("Enter necessary time in HH:MM:SS format.");
        String parsedTime = consoleReader();
        seconds = Integer.parseInt(parsedTime.substring(parsedTime.length() - 2));
        if (isNegative(seconds)) {
            System.out.println(ERROR);
            return;
        }
        trafficLightColorDetection(seconds);
    }

    private String consoleReader() {
        try (BufferedReader bF = new BufferedReader(new InputStreamReader(System.in))) {
            return bF.readLine();
        } catch (NumberFormatException | IOException e) {

        }
        return "";
    }

    private void trafficLightColorDetection(int sec) {
        if (sec % 60 < 35) {
            System.out.print(ANSI_GREEN + "Green light" + ANSI_RESET);
        } else if (sec % 60 >= 35 && sec % 60 < 40 || sec % 60 >= 55) {
            System.out.print(ANSI_YELLOW + "Yellow Light" + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + "Red light" + ANSI_RESET);
        }
    }

    private boolean isNegative(int input) {
        return input < 0;
    }

    private boolean dayOverCheck(int input) {
        return input < 86399;
    }

    private boolean isDigit(String input) {
        try{
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

