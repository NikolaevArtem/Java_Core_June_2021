package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {
    public static final String RED = "\u001b[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001b[0m";

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int numb;
        System.out.println("Please enter time in seconds:");
        if (!sc.hasNextInt()) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            return;
        } else {
            numb = sc.nextInt();
            if (numb < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
                return;
            } else if (numb > 86399) {
                System.out.println("The day is over");
                return;
            } else {
                color(numb);
            }
        }
    }

    public static void color(int sec){
        int light = sec % 60;
        if ((light >=0) && (light < 35)) {
            System.out.println(GREEN + "GREEN" + RESET);
        } else if (((light >=35) && (light < 40)) || ((light >=55) && (light < 60))) {
            System.out.println(YELLOW + "YELLOW" + RESET);
        } else {
            System.out.println(RED + "RED" + RESET);
        }
    }
}
