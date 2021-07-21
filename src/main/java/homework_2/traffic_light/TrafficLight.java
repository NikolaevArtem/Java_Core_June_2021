package homework_2.traffic_light;

import homework_2.IOMod;

import java.io.IOException;

import static homework_2.IOMod.*;

public class TrafficLight {

    void run() {
        menu();
    }

    private void menu() {
        System.out.print("Please, input seconds gone from the day start: ");
        try {
            int secondsGone = IOMod.bufferedReaderIntReader();
            if (secondsGone < 0) {
                System.out.println(BLUE_BG + ANSI_YELLOW + "WARNING: " + ANSI_RESET + BLUE_BG +
                        "INCORRECT VALUE! ONLY POSITIVE INTEGER NUMBERS AVAILABLE AS A VALUE" + ANSI_RESET);
                return;
            } else if (secondsGone >= 86400) {
                System.out.println(PURPLE_BG + ANSI_YELLOW + "ATTENTION: " + ANSI_RESET + PURPLE_BG +
                        "Day has been already finished." + ANSI_RESET);
                return;
            } else if (secondsGone >= 0 && secondsGone < 60) {
                colorPick(secondsGone);
            } else {
                colorPick(secondsGone % 60);
            }
        } catch (NumberFormatException nfe) {
            System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                    "ONLY INTEGER NUMBER AS VALUE AVAILABLE.");
        } catch (IOException e) {
            System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                    "IOException!");
        }
    }

    private static void colorPick(int secs) {
        System.out.print("Traffic Lights set to: ");
        // 0 <= light < 35 green, 35 <= light < 40 yellow, 40 <= light < 60 red
        if (secs >= 0 && secs < 35) {
            System.out.println(ANSI_GREEN + "GREEN");
        } else if (secs >= 35 && secs < 40) {
            System.out.println(ANSI_YELLOW + "YELLOW");
        } else if (secs >= 40 && secs < 60) {
            System.out.println(ANSI_RED + "RED");
        }
        System.out.print(ANSI_RESET);
    }

}
