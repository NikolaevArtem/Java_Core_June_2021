package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void run() {

        int seconds;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            seconds = Integer.parseInt(reader.readLine());

            if(seconds>86399) {
                System.out.println("The day is over");
                return;
            }
            if(seconds<0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
                return;
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            return;
        }

        int result;

        if(seconds>60) {
            result = seconds % 60;
        }
        else result = seconds;

        if (result<35){
            System.out.println("GREEN");
        } else if(result<40){
            System.out.println("YELLOW");
        } else if(result<55){
            System.out.println("RED");
        } else {
            System.out.println("YELLOW");
        }
    }
}
