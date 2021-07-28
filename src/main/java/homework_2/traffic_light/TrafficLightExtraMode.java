package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLightExtraMode extends TrafficLight {

    @Override
    protected boolean validation() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            if (!input.contains(":")) {
                return false;
            }
            String[] time = input.split(":");
            if (time.length != 3) {
                return false;
            }
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            seconds = Integer.parseInt(time[2]);
            if ((hours < 0 || hours > 23)
                    || (minutes < 0 || minutes > 59)
                    || (seconds < 0 || seconds > 59)) {
                return false;
            }
        } catch (IOException | NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void printErrorMessage() {
        System.out.println("Only input in format hh:mm:ss is allowed");
    }
}
