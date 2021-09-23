package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter time in seconds: ");
            int seconds = Integer.parseInt(reader.readLine());
            System.out.println();

            new PrintColor().print(seconds);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Only 1 non-negative integer is allowed as passed parameter" + ANSI_RESET);
        }
    }
}
