package homework_2.trafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Strategy {
    private final BufferedReader bF = new BufferedReader(new InputStreamReader(System.in));

    private final String ANSI_RESET = "\u001b[0m";

    private final String ANSI_RED = "\u001B[31m";

    private final String ANSI_GREED = "\u001B[32m";

    private final String ANSI_YELLOW = "\u001B[33m";

    private int seconds;

    private final boolean greenLight = seconds % 60 < 35;

    private final boolean yellowLight = seconds % 60 >= 35 && seconds % 60 <= 40 || seconds % 60 >= 55;

    public void choosingStrategy() throws IOException {
        System.out.println("""
                Choose input format:\s
                1.HH:MM:SS format
                2.Total amount of seconds.""");
        String strategy = bF.readLine();
        if (strategy.startsWith("1")) {
            timeFormat();
        } else secondsFormat();
    }

    private void secondsFormat() throws IOException {
        System.out.println("Enter necessary amount of seconds.");
        seconds = Integer.parseInt(bF.readLine());
        if (seconds > 86399) {
            System.out.println("Day is over");
            return;
        }
        if (greenLight) {
            System.out.println(ANSI_GREED + "Green light" + ANSI_RESET);
        } else if (yellowLight) {
            System.out.println(ANSI_YELLOW + "Yellow Light" + ANSI_RESET);
        } else System.out.println(ANSI_RED + "Red light" + ANSI_RESET);
    }

    private void timeFormat() throws IOException {
        System.out.println("Enter necessary amount of seconds.");
        String parsedTime = bF.readLine();
        seconds = Integer.parseInt(parsedTime.substring(parsedTime.length() - 2));
        if (greenLight) {
            System.out.println(ANSI_GREED + "Green light" + ANSI_RESET);
        } else if (yellowLight) {
            System.out.println(ANSI_YELLOW + "Yellow Light" + ANSI_RESET);
        } else System.out.println(ANSI_RED + "Red light" + ANSI_RESET);
    }
}
