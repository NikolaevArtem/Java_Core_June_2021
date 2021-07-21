package homework_2.traffic_light;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * todo Document type TrafficLightExtraMode
 */
public class TrafficLightExtraMode extends TrafficLight {

    @Override
    public void start() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if (isValid(inputStr)) {
            System.out.println(getTrafficLight(LocalTime.parse(inputStr).toSecondOfDay()));
        }
        scanner.close();
    }

    @Override
    public boolean isValid(String arg) {
        try {
            LocalTime.parse(arg).toSecondOfDay();
            return true;
        } catch (DateTimeException exception) {
            System.out.println(ANSI_RED + "Only hh:mm:ss input format (hh < 24, mm < 60, ss < 60)" + ANSI_RESET);
            return false;
        }
    }
}
