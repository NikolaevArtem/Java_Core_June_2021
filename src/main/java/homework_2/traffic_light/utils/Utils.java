package homework_2.traffic_light.utils;

import homework_2.traffic_light.exception.TrafficLightException;
import homework_2.traffic_light.utils.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            throw new TrafficLightException(MessageType.ERROR_MESSAGE);
        }
    }

}
