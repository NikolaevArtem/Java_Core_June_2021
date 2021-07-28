package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String START_MESSAGE = "Please, input number of seconds:";
    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    protected int seconds;

    public void run() {
        System.out.println(START_MESSAGE);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            seconds = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (seconds < 0) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        if (seconds > 86399) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        printColor();
    }

    protected void printColor() {
        if (seconds % 60 < 35) {
            System.out.println(GREEN + "GREEN" + RESET);
        } else if (seconds % 60 < 40 || seconds % 60 >= 55) {
            System.out.println(YELLOW + "YELLOW" + RESET);
        } else {
            System.out.println(RED + "RED" + RESET);
        }
    }
}
