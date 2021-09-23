package homework_2.traffic_light;

import java.util.Scanner;

public class ExtraTrafficLight {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static void trafficLight(String inputStr) {
        String[] arr;

        if (!inputStr.matches("\\d\\d:\\d\\d:\\d\\d")) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        } else {
            arr = inputStr.split(":");
            int hoursSec = Integer.parseInt(arr[0]) * 60 * 60;
            int minutesSec = Integer.parseInt(arr[1]) * 60;
            int seconds = Integer.parseInt(arr[2]);

            if (hoursSec > 24 * 60 * 60 || minutesSec > 60 * 60 || seconds >= 60) {
                System.out.println("The day is over");
                return;
            }

            int timeInSeconds = seconds + minutesSec * 60 + hoursSec * 60 * 60;
            int cycleOfTrafficLight = 60;
            int secForLight = timeInSeconds % cycleOfTrafficLight;

            if (secForLight >= 0 && secForLight < 35) {
                System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
            }
            if (secForLight >= 35 && secForLight < 40 || secForLight >= 55) {
                System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
            }
            if (secForLight >= 40 && secForLight < 55) {
                System.out.println(ANSI_RED + "RED" + ANSI_RESET);
            }
        }
    }

    public void run() {
        System.out.println("Please type your current time in HH:MM:SS format:");
        String inputData = readData();
        trafficLight(inputData);
    }

    private String readData() {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            return str;
        } catch (NumberFormatException e) {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }
}
