package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private int light;

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            light = Integer.parseInt(reader.readLine());

            if (light < 0) {
                throw new NumberFormatException();
            }

            if (light > 86399) {
                System.out.println("The day is over");

            } else {
                light %= 60;

                if (light < 35) {
                    System.out.println("GREEN");
                }

                if ((35 <= light && light < 40) || (55 <= light)) {
                    System.out.println("YELLOW");
                }

                if (40 <= light && light < 55) {
                    System.out.println("RED");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
