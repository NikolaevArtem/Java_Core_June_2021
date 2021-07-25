package homework_2.traffic_light;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class TrafficLight {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static void trafficLight(String secondsStr) {
        int seconds = 0;
        try {
            seconds = Integer.parseInt(secondsStr);
            if (seconds < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
                return;
            } else if (seconds > 86399) {
                System.out.println("The day is over");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }

        int cycleOfTrafficLight = 60;
        int secForLight = seconds % cycleOfTrafficLight;

        if (secForLight < 35) {
            System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
        }
        if (secForLight >= 35 && secForLight < 40 || secForLight >= 55) {
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        }
        if (secForLight >= 40 && secForLight < 55) {
            System.out.println(ANSI_RED + "RED" + ANSI_RESET);
        }
    }

    public void run() {
        System.out.println("Please type your current time in seconds:");
        String inputData = readData();
        trafficLight(inputData);
    }

    private String readData() {
        String str;
        try (Scanner scanner = new Scanner(System.in)) {
            str = scanner.next();
        } catch (NoSuchElementException e) {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
        return str;
    }
}
