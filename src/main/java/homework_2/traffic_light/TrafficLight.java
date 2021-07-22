package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m" + "RED" + RESET;
    public static final String GREEN = "\u001B[32m" + "GREEN" + RESET;
    public static final String YELLOW = "\u001B[33m" + "YELLOW" + RESET;
    public static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Please, input a number of seconds:");
        try {
            int seconds = bufferedReaderReadConsole();
            validateInput(seconds);
            System.out.println(showLight(seconds));
        } catch (NumberFormatException | IOException ex) {
            System.out.println(ERROR);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private int bufferedReaderReadConsole() throws IOException, NumberFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        }
    }

    private void validateInput(int i) throws IllegalArgumentException{
        if (i < 0) {
            throw new IllegalArgumentException(ERROR);
        } else if (i > 86399) {
            throw new IllegalArgumentException("The day is over");
        }
    }

    private String showLight(int i) {

        int secondsMod = i % 60;
        return secondsMod < 35 ? GREEN
                : secondsMod < 40 ? YELLOW
                : secondsMod < 55 ? RED
                : YELLOW;
    }
}
