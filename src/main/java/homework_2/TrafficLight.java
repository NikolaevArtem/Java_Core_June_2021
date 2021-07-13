package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int i = Integer.parseInt(reader.readLine());
                if (i < 0) {
                    System.out.println("Error: positive only");
                } else if (i > 86399) {
                    System.out.println("Error: day is over");
                } else {
                    if (i % 60 < 35) {
                        System.out.println("Green");
                    } else if (i % 60 < 40) {
                        System.out.println("Yellow");
                    } else if (i % 60 < 55) {
                        System.out.println("Red");
                    } else {
                        System.out.println("Yellow");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: integer only");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
