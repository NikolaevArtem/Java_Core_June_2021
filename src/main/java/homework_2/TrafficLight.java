package homework_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        try {
            int secondsValue = readIntFromConsole();
            if (secondsValue < 0) {
                printError("Only positive int numbers are allowed!");
                }
            else if (secondsValue > 86399) {
                printError("Day is over!");
            }
            else {
                printTrafficLight(secondsValue);
            }
        } catch (Exception e) {
            printError("Only int numbers are allowed!");
        }
    }

    private static void printTrafficLight(int secondsValue) {
        int SecondsInLastMinute = getSecondsInLastMinute(secondsValue);
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
        System.out.println(currentColor + "Current traffic light is " + currentColorText + "\u001B[0m");
    }

    public static void printError (String Message){
        System.out.println(ANSI_RED + "Error! " + Message + "\u001B[0m");
    }

    private static int getSecondsInLastMinute(int secNumber) {
        int minutes = secNumber / 60;
        return secNumber - minutes * 60;
    }

    private static int readIntFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter seconds value from 0 - 86399: ");
            return Integer.parseInt(reader.readLine());
        }
    }

}