package Homework2.Traffic_Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = 0;
        try {
            input = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Input does not contain numbers");

        }
        trafficLight.getTrafficLight(input);

    }
}
