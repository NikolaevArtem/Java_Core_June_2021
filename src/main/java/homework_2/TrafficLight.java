package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public static void main(String[] args) {
        while (true) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter seconds or \"stop\"");
                String inputStr = bufferedReader.readLine();
                try {
                    if (inputStr.equals("stop")) {
                        System.out.println("Exit...");
                        break;
                    }
                    int seconds = Integer.parseInt(inputStr);
                    if (seconds < 0 || seconds > 86399) {
                        System.err.println("Input String is out of range");
                    } else if (seconds % 60 < 35) {
                        System.out.println("Colour of traffic light is GREEN");
                    } else if (seconds % 60 < 40) {
                        System.out.println("Colour of traffic light is YELLOW");
                    } else if (seconds % 60 < 55) {
                        System.out.println("Colour of traffic light is RED");
                    } else {
                        System.out.println("Colour of traffic light is YELLOW");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Can't parse input string to integer");
                }
            } catch (IOException e) {
                System.err.println("Buffered reader throws IOException");
            }
        }
    }
}
