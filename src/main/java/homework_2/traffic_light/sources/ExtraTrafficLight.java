package homework_2.traffic_light.sources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static homework_2.Colors.*;

public class ExtraTrafficLight {

    public void run(String arg) {
        if (arg.equalsIgnoreCase("now")) {
            int seconds = getTime();
            colorPick(seconds%60);
        } else {
            System.out.println("Incorrect argument. You can call this app as:\n" +
                    PURPLE_BG + "java Main -now" + ANSI_RESET);
        }
    }

    private int getTime() {
        LocalDateTime now = LocalDateTime.now();
        String nowStr = now.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        System.out.println("Current time is: " + nowStr);
        return now.toLocalTime().toSecondOfDay();
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
