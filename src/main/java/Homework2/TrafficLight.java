package Homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            int input = 0;

            try {
                input = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Input does not contain numbers");
                continue;
            }

            if (input < 0) {
                System.out.println("Error. You can't enter negative numbers");
                continue;

            } else if (input > 86399) {
                System.out.println("Error. The day has come to an end");
                continue;
            }

            int lightInterval = input % 60;
            if (lightInterval >= 0 && lightInterval < 35) {
                System.out.println("Green");
            } else if (lightInterval >= 35 && lightInterval < 40) {
                System.out.println("Yellow");
            } else if (lightInterval >= 40 && lightInterval < 55) {
                System.out.println("Red");
            } else if (lightInterval >= 55 && lightInterval < 60) {
                System.out.println("Yellow");
            }
        }
    }
}
