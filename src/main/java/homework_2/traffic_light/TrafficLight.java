package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter seconds:");
            String inputStr = bufferedReader.readLine();
            try {
                int seconds = Integer.parseInt(inputStr);
                if (seconds < 0 || seconds > 86399) {
                    System.out.println("Input String is out of range");
                }
                int remainderOfDivision = seconds % 60;
                if (remainderOfDivision < 35) {
                    System.out.println("Colour of traffic light is GREEN");
                } else if (remainderOfDivision < 40) {
                    System.out.println("Colour of traffic light is YELLOW");
                } else if (remainderOfDivision < 55) {
                    System.out.println("Colour of traffic light is RED");
                } else {
                    System.out.println("Colour of traffic light is YELLOW");
                }
            } catch (NumberFormatException e) {
                System.out.println("Can't parse input string to integer");
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            System.err.println("Buffered reader throws IOException");
        }
    }
}
