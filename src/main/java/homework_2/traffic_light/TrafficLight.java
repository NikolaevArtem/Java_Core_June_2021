package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";

    public void run() {
        System.out.println("Please, input time:");
        String input = setInput();
        if (isValid(input)) {
            int seconds = getSeconds(input);
            printColor(seconds);
        } else {
            printErrorMessage();
        }
    }

    protected String setInput() {
        try(BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    protected boolean isValid(String inputString) {
        if(inputString == null) {
            return false;
        }
        return inputString.matches("\\d+");
    }

    protected int getSeconds(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    private void printColor(int seconds) {
        if (isDayOver(seconds)) {
            System.out.println("day is over");
            return;
        }
        if (seconds % 60 < 35) {
            System.out.println(GREEN + "GREEN" + RESET);
        } else if (seconds % 60 < 40 || seconds % 60 >= 55) {
            System.out.println(YELLOW + "YELLOW" + RESET);
        } else {
            System.out.println(RED + "RED" + RESET);
        }
    }

    protected boolean isDayOver(int seconds) {
        return seconds > 86399;
    }

    protected void printErrorMessage() {
        System.out.println("Only 1 non-negative integer is allowed as passed parameter");
    }
}
