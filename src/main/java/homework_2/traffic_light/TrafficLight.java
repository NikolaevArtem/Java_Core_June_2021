package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seconds;
        try {
            seconds = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Input error: The number of seconds can be a number only!");
            return;
        }
        if (seconds < 0) {
            System.out.println("Input error: The number of seconds should be positive!");
            return;
        }

        if (seconds > 86399) {
            System.out.println("Input error: The number of seconds is too big. The day is already over!");
            return;
        }
        if (seconds % 60 < 35) {
            System.out.println("Green");
        } else if (seconds % 60 < 40 || seconds % 60 >= 55) {
            System.out.println("Yellow");
        } else {
            System.out.println("Red");
        }
    }
}
