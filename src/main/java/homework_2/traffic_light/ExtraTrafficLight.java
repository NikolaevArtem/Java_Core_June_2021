package homework_2.traffic_light;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.traffic_light.ColorSelector.pickColor;


public class ExtraTrafficLight {

    public static void run() {
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
        if ((hours < 0 || hours >= 24)) {
            throw new InputMismatchException();
        }
        if (minutes < 0 || minutes >= 60) {
            throw new InputMismatchException();
        }
        if (seconds < 0 || seconds >= 60) {
            throw new InputMismatchException();
        }
        if (length > 3) {
            throw new InputMismatchException();
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