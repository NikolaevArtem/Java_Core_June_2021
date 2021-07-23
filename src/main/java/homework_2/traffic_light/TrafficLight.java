package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TrafficLight implements Runnable {

    public static final String ERROR_MESSAGE;
    public static final String RED_LIGHT_MESSAGE;
    public static final String YELLOW_LIGHT_MESSAGE;
    public static final String GREEN_LIGHT_MESSAGE;
    public static final String DAY_IS_OVER_MESSAGE;
    public static final String REGEX;  

    static {
        ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
        DAY_IS_OVER_MESSAGE = "The day is over";
        RED_LIGHT_MESSAGE = "\u001b[31m RED \u001b[0m";
        YELLOW_LIGHT_MESSAGE = "\u001b[33m YELLOW \u001b[0m";
        GREEN_LIGHT_MESSAGE = "\u001b[32m GREEN \u001b[0m";
        REGEX = "\\d+";
    }

    Pattern pattern = Pattern.compile(REGEX);

    @Override
    public void run() {
        startGreeting();
        Scanner scanner = new Scanner(System.in);
        String consoleString = scanner.nextLine();
        scanner.close();
        if (numberFormatIsValid(consoleString)) {
            consoleString = consoleString.replaceAll("\\D+", "");
            System.out.println(getTrafficLightColor(Integer.parseInt(consoleString)));
        }
    }

    protected void startGreeting() {
        System.out.println("Welcome to the Traffic Light Application");
        System.out.println("Enter the number of seconds since the start of the day");
    }

    protected String readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String consoleString = bufferedReader.readLine();
        return consoleString;
    }

    protected boolean numberFormatIsValid(String consoleString) {
        if (consoleString == null || consoleString.length() == 0) {
            return false;
        }
        if (!pattern.matcher(consoleString).matches()) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(consoleString) > 86399) {
            System.out.println(DAY_IS_OVER_MESSAGE);
            return false;
        }
        return true;
    }

    protected String getTrafficLightColor(int seconds) {
        int secInMin = Math.floorMod(seconds, 60);
        System.out.println("seconds= " + seconds);
        System.out.println("secInMin= " + secInMin);
        if (secInMin >= 0 && secInMin < 35) {
            return GREEN_LIGHT_MESSAGE;
        }
        if ((secInMin >= 35 && secInMin < 40) || (secInMin >= 55 && secInMin < 60)) {
            return YELLOW_LIGHT_MESSAGE;
        }
        if (secInMin >= 40 && secInMin < 55) {
            return RED_LIGHT_MESSAGE;
        }
        return ERROR_MESSAGE;
    }
}
