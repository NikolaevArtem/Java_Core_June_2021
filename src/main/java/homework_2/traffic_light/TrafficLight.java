package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {

    private int seconds;

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            if (valid(reader.readLine())) {
                printLight();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printLight() {

        int mod = seconds % 60;

        if (mod < 35) {
            System.out.println("Green");
        } else if (mod < 40) {
            System.out.println("Yellow");
        } else if (mod < 55) {
            System.out.println("Red");
        } else {
            System.out.println("Yellow");
        }

    }

    private boolean valid(String s) {

        try {
            seconds = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Error: integer only");
            return false;
        }

        if (seconds < 0) {
            System.out.println("Error: positive only");
            return false;
        }

        if (seconds > 86399) {
            System.out.println("Error: day is over");
            return false;
        }

        return true;
    }

}
