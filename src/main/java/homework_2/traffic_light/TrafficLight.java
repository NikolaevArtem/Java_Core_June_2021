package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {

    private static final String ANSI_GREEN  = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_RESET  = "\u001B[0m";

    public void run() {
        System.out.print("Enter time in seconds: ");

        int passedSeconds;
        try (Scanner scan = new Scanner(System.in)) {
            String input = scan.nextLine().trim();
            passedSeconds = Integer.parseInt(input);
            validateInput(passedSeconds);
        } catch (NumberFormatException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int calculationSeconds = passedSeconds % 60;
        String light;
        if (calculationSeconds >= 0 && calculationSeconds < 35) {
            light = ANSI_GREEN + "GREEN" + ANSI_RESET;
        } else if ((calculationSeconds >= 35 && calculationSeconds < 40) || calculationSeconds >= 55) {
            light = ANSI_YELLOW + "YELLOW" + ANSI_RESET;
        } else {
            light = ANSI_RED + "RED" + ANSI_RESET;
        }

        System.out.println(light);
    }

    private void validateInput(int passedSeconds) {
        if (passedSeconds < 0) {
            throw new IllegalArgumentException("Only 1 non-negative integer is allowed as passed parameter");
        }
        if (passedSeconds >= 86400) {
            throw new IllegalArgumentException("The day is over");
        }
    }
}