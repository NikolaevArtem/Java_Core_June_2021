package homework_2.traffic_light;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ExtraModeTrafficLight {

    private static final String ANSI_GREEN  = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_RESET  = "\u001B[0m";

    public void run() {
        System.out.print("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        int passedSeconds;
        try (Scanner scan = new Scanner(System.in)) {
            String input = scan.nextLine().trim();
            LocalTime lc = LocalTime.parse(input);
            passedSeconds = lc.toSecondOfDay();
        } catch (DateTimeParseException e) {
            System.out.println("Not a valid hh:mm:ss format");
            return;
        }

        int calculationSeconds = passedSeconds % 60;
        String light;
        if (calculationSeconds >= 0 && calculationSeconds < 35) {
            light = ANSI_GREEN + "GREEN" + ANSI_RESET;
        } else if ((calculationSeconds >= 35 && calculationSeconds < 40) || calculationSeconds >= 55) {
            light = ANSI_YELLOW + "YELLOW" + ANSI_RESET;
        } else {
            light = ANSI_RED + "RED" + ANSI_RESET;
        }

        System.out.println(light);
    }
}