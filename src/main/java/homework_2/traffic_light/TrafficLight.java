package homework_2.traffic_light;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.traffic_light.ColorSelector.pickColor;

public class TrafficLight {

    public void run() {
        System.out.println("Provide time in seconds:");
        try (Scanner scan = new Scanner(System.in)) {
            int seconds = Integer.parseInt(scan.nextLine());
            if (seconds < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            } else if (seconds >= 86400) {
                System.out.println("Day is over.");
            } else {
                getSeconds(seconds);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }
    }

    private static void getSeconds(int seconds) {
        int sec = seconds % 60;
        if (sec >= 0 && sec < 35) {
            System.out.println(pickColor("green"));
        } else if ((sec >= 35 && sec < 40) || sec >= 55) {
            System.out.println(pickColor("yellow"));
        } else {
            System.out.println(pickColor("red"));
        }
    }
}