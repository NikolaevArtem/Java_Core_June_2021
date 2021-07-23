package homework_2.TrafficLight;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class TrafficLight {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLACK = "\u001B[0m";

    private int inputInt;

    public void run() {
        try {
            if (readFromConsole()) {
                printTrafficLight();
            }
        } catch (Exception e) {
            printError("Only 1 non-negative integer is allowed as passed parameter");
        }
    }

    private void printTrafficLight() {
        int SecondsInLastMinute = inputInt % 60;
        String currentColor, currentColorText;
        if (SecondsInLastMinute < 35) {
            currentColorText = "green";
            currentColor = ANSI_GREEN;
        } else if (SecondsInLastMinute < 40) {
            currentColorText = "yellow";
            currentColor = ANSI_YELLOW;
        } else if (SecondsInLastMinute < 55) {
            currentColorText = "red";
            currentColor = ANSI_RED;
        } else {
            currentColorText = "yellow";
            currentColor = ANSI_YELLOW;
        }
        System.out.println(currentColor + currentColorText.toUpperCase() + ANSI_BLACK);
    }

    public static void printError(String Message) {
        System.out.println(ANSI_RED + "Error! " + Message + ANSI_BLACK);
    }

    boolean readFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter seconds value (int) from 0 - 86399: ");
            String inputString = reader.readLine();
            return validateInput(inputString);
        }
    }

    private boolean validateInput(String inputString) throws NumberFormatException {
        boolean result = false;
        int newInt = Integer.parseInt(inputString);
        if (newInt < 0) {
            printError("Only 1 non-negative integer is allowed as passed parameter");
        } else if (newInt > 86399) {
            printError("Day is over!");
        } else {
            inputInt = newInt;
            result = true;
        }
        return result;
    }

}