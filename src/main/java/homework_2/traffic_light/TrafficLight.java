package homework_2.traffic_light;

import homework_2.WrongInputException;

import java.io.IOException;

public class TrafficLight {
    private final int GREEN_TO_YELLOW = 35;
    private final int YELLOW_TO_RED = 40;
    private final int RED_TO_YELLOW = 55;

    private final int SEC_IN_MIN = 60;

    public void run() throws IOException {
        try {
            InputReader inputReader = new InputReader();
            int wholeSecs = inputReader.readSecs();

            int secs = wholeSecs % SEC_IN_MIN;

            printColor(secs);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printColor(int secs) {
        if (secs < GREEN_TO_YELLOW) {
            System.out.println("GREEN");
        } else if (secs < YELLOW_TO_RED) {
            System.out.println("YELLOW");
        } else if (secs < RED_TO_YELLOW) {
            System.out.println("RED");
        } else {
            System.out.println("YELLOW");
        }
    }

}
