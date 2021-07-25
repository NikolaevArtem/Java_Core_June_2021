package homework_2.traffic_light.utils;

import homework_2.traffic_light.exception.TrafficLightException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homework_2.traffic_light.utils.Constants.ERROR_MESSAGE;

public class Utils {

    public static void printMessage(String text) {
        System.out.print(text);
    }

    public static boolean isExtraMode(String mode) {
        return mode.equals("1");
    }

    public static String getData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new TrafficLightException(ERROR_MESSAGE);
        }
    }
}
