package homework_2.traffic_light;

import ConsoleColors.ConsoleColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {

        System.out.println("Enter the number, please.");
        String stringSeconds = getInput();
        if (isValid(stringSeconds)) {
            int seconds = Integer.parseInt(stringSeconds);
            getLight(seconds);
        }
    }

    private String getInput() {
        String result = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println(ERR_MSG);
        }
        return result;
    }


    private void getLight(int seconds) {

        if (seconds < 0) {
            System.out.println(ERR_MSG);
        } else if (seconds > 86399) {
            System.out.println("The day is over");
            return;
        }

        int justSeconds = seconds % 60;

        if (justSeconds < 35) {
            System.out.println(ConsoleColors.GREEN + "GREEN" + ConsoleColors.RESET);
        } else if ((justSeconds < 40) || (justSeconds >= 55)) {
            System.out.println(ConsoleColors.YELLOW + "YELLOW" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "RED" + ConsoleColors.RESET);
        }

    }

    private boolean isValid(String str) {

        boolean result = false;
        if (str == null || !str.chars().allMatch(Character::isDigit)) {
            System.out.println(ERR_MSG);
            return false;
        } else if (str.chars().allMatch(Character::isDigit)) {
            result = true;
        }
        return result;
    }
}
