package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    private static final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";
    private static final String RED = "\u001B[31mRED\u001B[0m";
    private static final String YELLOW = "\u001B[33mYELLOW\u001B[0m";
    private static final String GREEN = "\u001B[33mGREEN\u001B[0m";

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter seconds:");
            String inputStr = bufferedReader.readLine();
            try {
                int seconds = Integer.parseInt(inputStr);
                if (seconds < 0) {
                    System.out.println(ERROR_MSG);
                } else if (seconds > 86399) {
                    System.out.println("The day is over");
                } else {
                    int remainderOfDivision = seconds % 60;
                    if (remainderOfDivision < 35) {
                        System.out.println(GREEN);
                    } else if (remainderOfDivision < 40) {
                        System.out.println(YELLOW);
                    } else if (remainderOfDivision < 55) {
                        System.out.println(RED);
                    } else {
                        System.out.println(YELLOW);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MSG);
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.err.println(ERROR_MSG);
        }
    }
}
