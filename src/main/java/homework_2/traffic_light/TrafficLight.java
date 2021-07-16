package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static void main(String[] args) throws IOException {
        System.out.println("Choose input mode:\n1 - number of seconds\n2 - hh:mm:ss");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();

        int seconds;
        if(answer.equals("1")){
            try {
                seconds = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Input error: The number of seconds can be a number only!");
                return;
            }
        } else if(answer.equals("2")){
            String[] time = br.readLine().split(":");
            if(time.length != 3){
                System.out.println("Input error: Wrong input format!");
                return;
            }
            try {
                int hours = Integer.parseInt(time[0]);
                int minutes = Integer.parseInt(time[1]);
                seconds = 60 * 60 * hours + 60 * minutes + Integer.parseInt(time[2]);
            } catch (NumberFormatException nfe) {
                System.out.println("Input error: Values can be numbers only!");
                return;
            }
        } else{
            System.out.println("Unrecognizable answer!");
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
