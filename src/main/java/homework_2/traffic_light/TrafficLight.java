package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void run()  {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int light = Integer.parseInt(reader.readLine());
            int res = 60;
            int result = light % res;
            if (light < 0) {
                System.out.println("Please use positive number");
                return;
            }
            if (light > 86399) {
                System.out.println("Please use number between 0 and 86399");
                return;
            } else {
                if (result >= 0 && result < 35) {
                    System.out.println("green");
                }
                if (result >= 35 && result < 40) {
                    System.out.println("yellow");
                }
                if (result >= 40 && result < 60) {
                    System.out.println("red");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please use number");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
