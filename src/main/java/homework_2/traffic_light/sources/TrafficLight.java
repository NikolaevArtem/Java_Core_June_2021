package homework_2.traffic_light.sources;

import homework_2.IOMod;

import static homework_2.IOMod.*;
import static homework_2.Colors.*;

public class TrafficLight {

    public void run() {
        inputSeconds();
    }

    private void inputSeconds() {
        System.out.print("Please, input seconds gone from the day start: ");
        try {
            int secondsGone = IOMod.bufferedReaderIntReader();
            if (secondsGone < 0) {
                System.out.println(ERROR);
                return;
            } else if (secondsGone >= 86400) {
                System.out.println("The day is over");
                return;
            } else {
                colorPick(secondsGone % 60);
            }
        } catch (NumberFormatException exc) {
            System.out.println(ERROR);
        }
    }

    private void colorPick(int secs) {
        // 0 <= light < 35 green, 35 <= light < 40 yellow, 40 <= light < 55 red, 55 <= light < 60 yellow
        if (secs >= 0 && secs < 35) {
            lightPrint(ANSI_GREEN, "GREEN");
        } else if ((secs >= 35 && secs < 40) || (secs >= 55 && secs < 60)) {
            lightPrint(ANSI_YELLOW, "YELLOW");
        } else {
            lightPrint(ANSI_RED, "RED");
        }
    }

    private void lightPrint(String consoleColor, String lightColor) {
        System.out.println(consoleColor + lightColor + ANSI_RESET);
    }

}
