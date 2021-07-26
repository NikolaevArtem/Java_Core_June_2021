package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            str = reader.readLine();
            int time = Integer.parseInt(str);
            if (time < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter ");
            } else if (time > 86399) {
                System.out.println("The day is over");
            } else {
                int light = time % 60;
                if (light < 35) {
                    System.out.println("GREEN");
                } else if (light < 40) {
                    System.out.println("YELLOW");
                } else if (light < 55) {
                    System.out.println("RED");
                } else {
                    System.out.println("YELLOW");
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }
    }
}

