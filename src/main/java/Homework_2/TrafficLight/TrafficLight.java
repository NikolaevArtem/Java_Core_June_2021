package Homework_2.TrafficLight;

import java.util.Scanner;

public class TrafficLight {
    protected static final String RED_COLOUR = "\u001B[31m";
    protected static final String GREEN_COLOUR = "\u001B[32m";
    protected static final String YELLOW_COLOUR = "\u001B[33m";
    protected static final String RESET_COLOUR = "\u001B[0m";

    protected void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time: valid range is from 0 to 86399 )");
        int seconds = 0;
        //reading the value of seconds
        try {
            seconds = scanner.nextInt();
            if (seconds < 0) {
                throw new Exception();
            }
            showingTrafficLightColor(seconds);
        }
        catch (Exception e){
            System.out.println("Only 1 non-negative integer is allowed as passed parameter! Please, try again");
            return;
        }
    }

    protected void showingTrafficLightColor(int sec){
        if (sec > 86399){
            System.out.println("The day is over");
            return;
        }
        sec = sec % 60;
        String res = "unknown error(";
        //YELLOW color
        if ((sec >= 35 && sec < 40) || (sec >= 55 && sec < 60)) {
            res = YELLOW_COLOUR + "YELLOW" + RESET_COLOUR;
        }
        //GREEN color
        if (sec >= 0 && sec < 35) {
            res = GREEN_COLOUR + "GREEN" + RESET_COLOUR;
        }
        //RED color
        if (sec >= 40 && sec < 55) {
            res = RED_COLOUR + "RED" + RESET_COLOUR;
        }
        System.out.println(res);
    }

}
