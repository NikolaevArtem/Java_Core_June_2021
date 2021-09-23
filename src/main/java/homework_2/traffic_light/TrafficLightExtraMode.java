package homework_2.traffic_light;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

public class TrafficLightExtraMode extends TrafficLight {

    private int secondsParsed;

    @Override
    public void run() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if (isValid(inputStr)) {
            String result = getTrafficLight(secondsParsed);
            System.out.println(result);
        }
        scanner.close();
    }

    @Override
    public boolean isValid(String... arg) {
        if (arg.length > 1) return false;
        try {
            secondsParsed = LocalTime.parse(arg[0]).toSecondOfDay();
        } catch (DateTimeException exception) {
            System.out.println(ANSI_RED + "Only hh:mm:ss input format (hh < 24, mm < 60, ss < 60)" + ANSI_RESET);
            return false;
        }
        return true;
    }
}
