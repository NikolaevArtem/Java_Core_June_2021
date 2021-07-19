package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.lineSeparator;

public class TrafficLight {
    private static final String INFO_MESSAGE = "Hi! This is your guide to cross the road blindly!\n" +
            "Please choose the format to enter the time:\n" +
            "1 - time in format hh:mm:ss. From 00:00:00 to 23:59:59\n" +
            "2 - time in seconds. From 0 to 86399.";
    private static final String INFO_MESSAGE_TO_CHOOSE_MODE = "Please enter 1 or 2.";
    private static final String INFO_MESSAGE_TO_MODE_1 = "Please enter time in format hh:mm:ss. From 00:00:00 to 23:59:59.";
    private static final String INFO_MESSAGE_TO_MODE_2 = "Please enter time in seconds. From 0 to 86399.";
    private static final String ERROR_MESSAGE = "Something went wrong. Please restart the program!";
    private static final String WARNING_MESSAGE_POSITIVE_NUMS = "You should enter only positive numbers or 0.";
    private static final String WARNING_MESSAGE_INCORRECT_FORMAT = "You entered time in wrong format.";
    private static final String WARNING_MESSAGE_EXCEED_LIMIT = "Please do not exceed the time limits. There are only 86399 seconds or 24 hours in a day!";
    private static final String LIGHT_RED = "\u001B[31m" + "RED" + "\u001B[0m" + "\nDo not cross the road!";
    private static final String LIGHT_GREEN = "\u001B[32m" + "GREEN" + "\u001B[0m" + "\nYou can cross the road!";
    private static final String LIGHT_YELLOW = "\u001B[33m" + "YELLOW" + "\u001B[0m" + "\nDo not cross the road, wait a little!";
    private static final int SECONDS_IN_DAY = 86399;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            printMessage(INFO_MESSAGE);
            int mode = getMode(reader);
            checkLight(mode, reader);
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    private int getMode(BufferedReader reader) throws IOException {
        while (true) {
            String choice = reader.readLine();
            if (choice.equals("1") || choice.equals("2")) {
                return Integer.parseInt(choice);
            }
            printMessage(INFO_MESSAGE_TO_CHOOSE_MODE);
        }
    }

    private void checkLight(int mode, BufferedReader reader) throws IOException {
        String line;
        if (mode == 1) {
            printMessage(INFO_MESSAGE_TO_MODE_1);
            line = reader.readLine();
            if (isValidString(line)) {
                printLight(parseToSeconds(line));
            } else {
                checkLight(mode, reader);
            }
        } else {
            printMessage(INFO_MESSAGE_TO_MODE_2);
            line = reader.readLine();
            if (isValidSeconds(line)) {
                printLight(Integer.parseInt(line));
            } else {
                checkLight(mode, reader);
            }
        }
    }

    private boolean isValidString(String time) {
        String[] timeArray = time.trim().split(":");
        if (timeArray.length != 3) {
            printMessage(WARNING_MESSAGE_INCORRECT_FORMAT + lineSeparator());
            return false;
        } else if (time.contains("-")) {
            printMessage(WARNING_MESSAGE_POSITIVE_NUMS + lineSeparator());
            return false;
        }
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        if (hours > 23 || minutes > 59 || seconds > 59) {
            printMessage(WARNING_MESSAGE_EXCEED_LIMIT + lineSeparator());
            return false;
        }
        return true;
    }

    private boolean isValidSeconds(String time) {
        int seconds;
        try {
            seconds = Integer.parseInt(time);
            if (seconds < 1) {
                printMessage(WARNING_MESSAGE_POSITIVE_NUMS + lineSeparator());
                return false;
            }
        } catch (NumberFormatException e) {
            printMessage(WARNING_MESSAGE_INCORRECT_FORMAT + lineSeparator());
            return false;
        }
        return seconds <= SECONDS_IN_DAY;
    }

    private int parseToSeconds(String time) {
        String[] timeArray = time.split(":");
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);
        return hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds;
    }

    private void printLight(int seconds) {
        int reminder = seconds % SECONDS_IN_MINUTE;
        if (reminder >= 0 && reminder < 35) {
            printMessage(LIGHT_GREEN);
        } else if (reminder >= 35 && reminder < 40) {
            printMessage(LIGHT_YELLOW);
        } else {
            printMessage(LIGHT_RED);
        }
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}