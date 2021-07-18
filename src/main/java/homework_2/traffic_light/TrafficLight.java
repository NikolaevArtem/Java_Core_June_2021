package homework_2.traffic_light;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.traffic_light.ColorTable.*;

public class TrafficLight {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Pick mode: 1 - provide seconds, 2 - provide time in format \"hh:mm:ss\": ");
        try {
            int mode = scan.nextInt();
            selectMode(mode);
        } catch (InputMismatchException e) {
            System.out.println("Only 1 or 2 allow");
        }
        scan.close();
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

    private static void selectMode(int mode) {
        if (mode == 1) {
            firstMode();
        } else if (mode == 2) {
            secondMode();
        } else {
            System.out.println("Wrong mode");
        }
    }

    private static void firstMode() {
        System.out.println("Provide time in seconds:");
        try {
            int seconds = scan.nextInt();
            if (seconds < 0) {
                System.out.println("Only positive numbers is allow, enter valid value");
                firstMode();
            } else if (seconds >= 86400) {
                System.out.println("Day is over, enter valid value");
                firstMode();
            } else {
                getSeconds(seconds);
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers is allow.");
        }
    }

    private static void secondMode() {
        System.out.println("Provide time in \"hh:mm:ss\" format: ");
        try {
            String nextLine = scan.next();
            String[] input = nextLine.split(":");
            int hours = Integer.parseInt(input[0]);
            int minutes = Integer.parseInt(input[1]);
            int seconds = Integer.parseInt(input[2]);

            validateMode2(hours, minutes, seconds, input.length);

            int globalseconds = seconds + minutes * 60 + hours * 3600;

            getSeconds(globalseconds);

        } catch (InputMismatchException e) {
            System.out.println("You entered an invalid date, try again");
            secondMode();
        } catch (NumberFormatException e) {
            System.out.println("Only numbers is allow, try again");
            secondMode();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect input, try again");
            secondMode();
        }
    }

    private static void validateMode2(int hours, int minutes, int seconds, int length) {
        if (hours < 0 || hours >= 24) {
            System.out.println("You entered an invalid hours field.");
            secondMode();
        }
        if (minutes < 0 || minutes >= 60) {
            System.out.println("You entered an invalid minutes field.");
            secondMode();
        }
        if (seconds < 0 || seconds >= 60) {
            System.out.println("You entered an invalid seconds field.");
            secondMode();
        }
        if (length > 3) {
            System.out.println("You entered an extra field.");
            secondMode();
        }
    }

    private static String pickColor(String color) {
        String message = "The traffic light is";
        if (color.equals("green")) {
            return message + ANSI_GREEN + " Green" + ANSI_RESET + " now";
        } else if (color.equals("yellow")) {
            return message + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now";
        } else
            return message + ANSI_RED + " Red" + ANSI_RESET + " now";
    }
}