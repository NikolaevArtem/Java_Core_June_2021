package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {
    private static final String RED = "\u001b[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001b[0m";
    private static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    public void run(){
        Scanner sc = new Scanner(System.in);
        int numb;
        String str;
        System.out.println("Please enter time in seconds:");
        if (!sc.hasNextInt()) {
            System.out.println(ERROR_MESSAGE);
            return;
        } else {
            str = sc.nextLine();
            str = str.trim();
            if (!str.matches("[-+]?\\d+")) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
            numb = Integer.parseInt(str);
            if (numb < 0) {
                System.out.println(ERROR_MESSAGE);
                return;
            } else if (numb > 86399) {
                System.out.println("The day is over");
                return;
            } else {
                printTrafficLight(numb);
            }
        }
        sc.close();
    }

    public void printTrafficLight(int sec){
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
