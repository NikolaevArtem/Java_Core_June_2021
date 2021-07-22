package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_YELLOW = "\u001b[33m";
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_RESET = "\u001b[0m";

    private void errorMsg(){
        System.out.println("Only 1 non-negative integer is allowed as passed parameter.");
    }

    private void showLight(int tmp) {
        if (0 <= tmp && tmp < 35) {
            System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
 //           System.out.println("GREEN");
        } else if ((35 <= tmp && tmp < 40) || (55 <= tmp && tmp < 60)) {
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        } else if (40 <= tmp && tmp < 55) {
            System.out.println(ANSI_RED + "RED" + ANSI_RESET);
        }
    }

    public void run() {
       System.out.println("Traffic Light App.");
       System.out.println("Enter the number of seconds between 0 and 86399 inclusive:");
        input();
    }

    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            if (isStringNumeric(str)) {
                int seconds = Integer.parseInt(str);
                if (seconds < 0) {
                    errorMsg();
                } else if (seconds > 86399) {
                    System.out.println("The day is over");
                } else {
                    int tmp = seconds % 60;
                    showLight(tmp);
                }
            } else {
                errorMsg();
            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    private boolean isStringNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}


