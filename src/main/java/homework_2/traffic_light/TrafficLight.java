package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final int BOUND_1 = 35;
    public static final int BOUND_2 = 40;
    public static final int BOUND_3 = 55;
    public static final int MAX_VALUE = 86399;

    public static final int SEC_IN_MIN = 60;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();
                if (!isInt(input)) {
                    if (input.trim().equals("exit")) {
                        break;
                    }
                    System.out.println("Wrong input format, try integer number, your input: " + input);
                    continue;
                }

                int light = Integer.parseInt(input);
                if (light < 0) {
                    System.out.println("Positive values supported only, your value: " + light);
                    continue;
                } else if (light > MAX_VALUE) {
                    System.out.println("Day's over, try smaller value");
                    continue;
                }

                light = light % SEC_IN_MIN;

                if (light < BOUND_1) {
                    System.out.println("GREEN");
                } else if (light < BOUND_2) {
                    System.out.println("YELLOW");
                } else if (light < BOUND_3) {
                    System.out.println("RED");
                } else {
                    System.out.println("YELLOW");
                }
            }
        }
    }

    private static boolean isInt(String str) {
        if (str == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
