package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {

    public void run() {
        Scanner in = new Scanner(System.in);
        Color printTraffic = new Color();
        System.out.println("Input number of seconds: ");
        String time = in.next();
        if (isValid(time)) {
            int seconds = Integer.parseInt(time);
            int sec = seconds % 60;
            if (seconds < 0 || seconds >= 86400)
                printTraffic.error();
            else if (sec >= 0 && sec < 35)
                printTraffic.green();
            else if ((sec >= 35 && sec < 40) || (sec >= 55 && sec < 60))
                printTraffic.yellow();
            else if (sec >= 40 && sec < 50)
                printTraffic.red();

        } else
            System.out.println("Only 1 non-negative integer integer is allowed as passed parameter");

    }

    public boolean isValid(String time) {
        return time.chars().allMatch(Character::isDigit);
    }
}
