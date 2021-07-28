package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    protected int seconds;

    public void run() {
        System.out.println("Please, input time:");
        if (validation()) {
            printColor();
        } else {
            printErrorMessage();
        }
    }

    protected boolean validation() {
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(System.in))) {
            seconds = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            return false;
        }
        return seconds >= 0 && seconds <= 86399;
    }

    private void printColor() {
        if (seconds % 60 < 35) {
            System.out.println(GREEN + "GREEN" + RESET);
        } else if (seconds % 60 < 40 || seconds % 60 >= 55) {
            System.out.println(YELLOW + "YELLOW" + RESET);
        } else {
            System.out.println(RED + "RED" + RESET);
        }
    }

    protected void printErrorMessage() {
        System.out.println("Only 1 non-negative integer is allowed as passed parameter");
    }
}
