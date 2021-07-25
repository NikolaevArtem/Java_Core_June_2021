package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrafficLight {

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {

                printLight(Integer.parseInt(reader.readLine()));

            } catch (NumberFormatException e) {
                System.out.println("Error: integer only");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void printLight (int seconds) {

        if (seconds < 0) {
            System.out.println("Error: positive only");
        } else if (seconds > 86399) {
            System.out.println("Error: day is over");
        } else {

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
    }
}
