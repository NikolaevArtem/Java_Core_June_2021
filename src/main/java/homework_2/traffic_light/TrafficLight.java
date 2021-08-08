package homework_2.traffic_light;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.traffic_light.ColorSelector.*;

class TrafficLight {

    public static void run() {
        System.out.println("Provide time in seconds:");
        try (Scanner scan = new Scanner(System.in)) {
            int seconds = scan.nextInt();
            if (seconds < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            } else if (seconds >= 86400) {
                System.out.println("Day is over.");
            } else {
                getSeconds(seconds);
            }
        } catch (InputMismatchException e) {
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

//    private static void selectMode(int mode) {
//        if (mode == 1) {
//            firstMode();
//        } else if (mode == 2) {
//            secondMode();
//        } else {
//            System.out.println("You entered wrong mode number.");
//        }
//    }


//    public static void greeting() {
//        System.out.println("Pick mode: 1 - provide seconds, 2 - provide time in format \"hh:mm:ss\": ");
//        try (Scanner scan = new Scanner(System.in)) {
//            int mode = scan.nextInt();
//            selectMode(mode);
//        } catch (InputMismatchException e) {
//            System.out.println("Only 1 or 2 allow");
//        }
//    }