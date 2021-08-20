package homework_2.traffic_light;

import base.BaseClazz;

import java.util.Scanner;

public class TrafficLight extends BaseClazz {

    private static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    @Override
    public void run() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine().trim();
        if (isValid(inputStr)) {
            if (Integer.parseInt(inputStr) < 86400) {
                int seconds = Integer.parseInt(inputStr);
                String result = getTrafficLight(seconds);
                System.out.println(result);
            } else {
                System.out.println(ANSI_RED + "Day is over" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
        }
        scanner.close();
    }

    protected String getTrafficLight(int numberOfSeconds) {
        int cutNumberOfSeconds = numberOfSeconds % 60;
        if (0 <= cutNumberOfSeconds && cutNumberOfSeconds < 35) {
            return ANSI_GREEN_BACKGROUND + "Green light" + ANSI_RESET;
        }
        if (35 <= cutNumberOfSeconds && cutNumberOfSeconds < 40 || cutNumberOfSeconds >= 55) {
            return ANSI_YELLOW_BACKGROUND + "Yellow light" + ANSI_RESET;
        }
        if (cutNumberOfSeconds >= 40) {
            return ANSI_RED_BACKGROUND + "Red light" + ANSI_RESET;
        }
        return "Something went wrong";
    }
}

