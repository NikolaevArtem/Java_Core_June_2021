package homework_2;

import java.io.IOException;

import static homework_2.IOMod.*;

public class TrafficLight {

    public static void main(String[] args) throws IOException {
        System.out.print("Please, input seconds gone from the day start: ");
        int secondsGone = IOMod.bufferedReaderIntReader();
        if (secondsGone == -1) {
            return;
        } else if (secondsGone >= 0 && secondsGone < 60) {
            colorPick(secondsGone);
        } else {
            colorPick(secondsGone % 60);
        }
    }

    private static void colorPick(int secs) {
        System.out.print("Traffic Lights set to: ");
        // 0 <= light < 35 зеленый, 35 <= light < 40 желтый, 40 <= light < 60 красный.
        if (secs >= 0 && secs < 35) {
            System.out.println(ANSI_GREEN + "GREEN");
        }
        if (secs >= 35 && secs < 40) {
            System.out.println(ANSI_YELLOW + "YELLOW");
        }
        if (secs >= 40 && secs < 60) {
            System.out.println(ANSI_RED + "RED");
        }
        System.out.print(ANSI_RESET);
    }

}
