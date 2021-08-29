package Homework2.Traffic_Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    final int END_OF_THE_DAY = 86399;

    String getTrafficLight(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Error. You can't enter negative numbers");

        } else if (input > END_OF_THE_DAY) {
            throw new IllegalArgumentException("Error. The day has come to an end");
        }
        int lightInterval = input % 60;
        String light = "";
        if (lightInterval >= 0 && lightInterval < 35) {
            light = "Green";
        } else if (lightInterval >= 35 && lightInterval < 40) {
            light = "Yellow";
        } else if (lightInterval >= 40 && lightInterval < 55) {
            light = "Red";
        } else if (lightInterval >= 55 && lightInterval < 60) {
            light = "Yellow";
        }
        return light;
    }

    public void run() {
        int input = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Input does not contain numbers");
        }
        System.out.println(getTrafficLight(input));
    }
}








