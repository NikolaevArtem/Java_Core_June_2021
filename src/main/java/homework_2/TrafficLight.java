package homework_2;

import java.util.Scanner;

public class TrafficLight {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        trafficLight();
    }

    private static void trafficLight() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please type your current time (in hh:mm:ss format):");
            String str = scanner.nextLine();
            String[] arr;

            if (str.matches("\\d\\d:\\d\\d:\\d\\d")) {
                arr = str.split(":");
                int hoursSec = Integer.parseInt(arr[0]) * 60 * 60;
                int minutesSec = Integer.parseInt(arr[1]) * 60;
                int secondsSec = Integer.parseInt(arr[2]);

                if (hoursSec < 0 || minutesSec < 0 || secondsSec < 0) {
                    System.out.println("Please type positive numbers");
                }
                if (hoursSec > 24 * 60 * 60 || minutesSec > 60 * 60 || secondsSec >= 60) {
                    System.out.println("Unfortunately this day has already finished");
                }

                int timeInSeconds = secondsSec + minutesSec * 60 + hoursSec * 60 * 60;
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
            } else {
                System.out.println("Wrong format. Please type your current time as HH:MM:SS");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
