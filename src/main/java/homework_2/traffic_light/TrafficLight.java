package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public void run() throws IOException {

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
                    System.out.println(ANSI_GREEN + "green" + ANSI_RESET);
                }
                if (result >= 35 && result < 40) {
                    System.out.println(ANSI_YELLOW + "yellow" + ANSI_RESET);
                }
                if (result >= 40 && result < 60) {
                    System.out.println(ANSI_RED + "red" + ANSI_RESET);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please use number");
            return;
        } finally {
            reader.close();
        }
    }
}
