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
            System.out.print("Green");
        } else if (mod < 40) {
            System.out.print("Yellow");
        } else if (mod < 55) {
            System.out.print("Red");
        } else {
            System.out.print("Yellow");
        }

    }

    private boolean valid(String s) {

        try {
            seconds = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.print("Error: integer only");
            return false;
        }

        if (seconds < 0) {
            System.out.print("Error: positive only");
            return false;
        }

        if (seconds > 86399) {
            System.out.print("The day is over");
            return false;
        }

        return true;
    }

}
