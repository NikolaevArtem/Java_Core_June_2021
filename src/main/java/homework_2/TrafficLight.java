package homework_2;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrafficLight {
    private static Scanner scan;
    private static int seconds;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        System.out.print("Enter number of mode: 1 - seconds, 2 - hh:mm:ss (<Ctrl + D> or <Ctrl + Z> to exit): ");

        while (scan.hasNext()) {
            int mode;
            try {
                mode = scan.nextInt();
                validateMode(mode);
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Not a number");
            }

            receiveSeconds(mode);

            seconds %= 60;
            String light;
            if (seconds >= 0 && seconds < 35) {
                light = "green";
            } else if ((seconds >= 35 && seconds < 40) || seconds >= 55) {
                light = "yellow";
            } else {
                light = "red";
            }

            System.out.println("Traffic light is " + light);
            System.out.print("\nEnter number of mode: 1 - seconds, 2 - hh:mm:ss (<Ctrl + D> or <Ctrl + Z> to exit): ");
        }
        scan.close();
    }

    private static void validateMode(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Illegal mode type");
        }
    }

    private static void receiveSeconds(int mode) {
        if (mode == 1) {
            System.out.print("Enter time in seconds: ");
            try {
                seconds = scan.nextInt();
                validateInputMode1(seconds);
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Not a number");
            }
        } else {
            System.out.print("Enter time in hh:mm:ss format: ");
            try {
                String line = scan.next();
                LocalTime lc = LocalTime.parse(line);
                seconds = lc.toSecondOfDay();
            } catch (DateTimeParseException e) {
                throw new DateTimeParseException("Not a hh:mm:ss format", e.getParsedString(), e.getErrorIndex());
            }
        }
    }

    private static void validateInputMode1(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
        if (i >= 86400) {
            throw new IllegalArgumentException("Day is over");
        }
    }
}
