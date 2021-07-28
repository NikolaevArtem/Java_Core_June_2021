package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLightExtraMode extends TrafficLight {

    public static final String ERROR_MESSAGE = "Only input in format hh:mm:ss is allowed";

    @Override
    public void run() {
        System.out.println(START_MESSAGE);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            if (!input.contains(":")) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
            String[] time = input.split(":");
            if (time.length != 3) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            seconds = Integer.parseInt(time[2]);
            if ((hours < 0 || hours > 23)
                    || (minutes < 0 || minutes > 59)
                    || (seconds < 0 || seconds > 59)) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return;
        }

        printColor();
    }
}
