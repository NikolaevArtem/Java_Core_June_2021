package homework_2.traffic_light;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.traffic_light.ColorTable.*;

public class TrafficLight {

    public static void greeting() {
        System.out.println("Pick mode: 1 - provide seconds, 2 - provide time in format \"hh:mm:ss\": ");
        try (Scanner scan = new Scanner(System.in)) {
            int mode = scan.nextInt();
            selectMode(mode);
        } catch (InputMismatchException e) {
            System.out.println("Only 1 or 2 allow");
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

    private static void selectMode(int mode) {
        if (mode == 1) {
            firstMode();
        } else if (mode == 2) {
            secondMode();
        } else {
            System.out.println("You entered wrong mode number.");
        }
    }

    protected static void firstMode() {
        System.out.println("Provide time in seconds:");
        try (Scanner scan = new Scanner(System.in)) {
            int seconds = scan.nextInt();
            if (seconds < 0) {
                System.out.println("Only non-negative numbers is allow.");
            } else if (seconds >= 86400) {
                System.out.println("Day is over.");
            } else {
                getSeconds(seconds);
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers is allow.");
        }
    }

    protected static void secondMode() {
        System.out.println("Provide time in \"hh:mm:ss\" format: ");
        try (Scanner scan = new Scanner(System.in)) {
            String nextLine = scan.next();
            String[] input = nextLine.split(":");
            int hours = Integer.parseInt(input[0]);
            int minutes = Integer.parseInt(input[1]);
            int seconds = Integer.parseInt(input[2]);
            validateSecondMode(hours, minutes, seconds, input.length);
            int globalseconds = seconds + minutes * 60 + hours * 3600;
            getSeconds(globalseconds);
        } catch (InputMismatchException e) {
            System.out.println("You entered an invalid date.");
        } catch (NumberFormatException e) {
            System.out.println("Only numbers is allow.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect input.");
        }
    }

    private static void validateSecondMode(int hours, int minutes, int seconds, int length) {
        if (hours < 0 || hours >= 24) {
            System.out.println("You entered an invalid hours field.");
        }
        if (minutes < 0 || minutes >= 60) {
            System.out.println("You entered an invalid minutes field.");
        }
        if (seconds < 0 || seconds >= 60) {
            System.out.println("You entered an invalid seconds field.");
        }
        if (length > 3) {
            System.out.println("You entered an extra field.");
        }
        throw new InputMismatchException();
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