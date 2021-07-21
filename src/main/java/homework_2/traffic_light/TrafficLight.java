package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {

    protected static final String ANSI_RESET = "\033[0m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    protected static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    protected static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public void start() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if (isValid(inputStr)) {
            inputStr = inputStr.replaceAll("\\s+", "");
            System.out.println(getTrafficLight(Integer.parseInt(inputStr)));
        }
        scanner.close();
    }

    protected boolean isValid(String arg) {
        if (!arg.matches("^\\s*[+]?[1-9][0-9]*\\s*$")) {
            System.out.println(ANSI_RED + "Only 1 non-negative integer is allowed as passed parameter" + ANSI_RESET);
            return false;
        }

        if (Integer.parseInt(arg) > 86399) {
            System.out.println(ANSI_RED + "Day is over" + ANSI_RESET);
            return false;
        }
        return true;
    }

    protected String getTrafficLight(int numberOfSeconds) {
        int cutNumberOfSeconds = numberOfSeconds - 60 * (numberOfSeconds / 60);
        if (cutNumberOfSeconds >= 0 && cutNumberOfSeconds < 35) {
            return ANSI_GREEN_BACKGROUND + "Green light" + ANSI_RESET;
        }
        if ((cutNumberOfSeconds >= 35 && cutNumberOfSeconds < 40) || (cutNumberOfSeconds >= 55 && cutNumberOfSeconds < 60)) {
            return ANSI_YELLOW_BACKGROUND + "Yellow light" + ANSI_RESET;
        }
        if (cutNumberOfSeconds >= 40 && cutNumberOfSeconds < 55) {
            return ANSI_RED_BACKGROUND + "Red light" + ANSI_RESET;
        }
        return "Something went wrong";
    }
}

