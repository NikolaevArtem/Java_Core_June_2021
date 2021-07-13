package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class TrafficLight {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String errorMsg = ANSI_RED + "Error!" + ANSI_RESET;

    public static void main(String[] args) throws IOException {
        System.out.println("Traffic Light App. \nTo exit enter - \"exit\".");
        System.out.println("Enter the number of seconds between 0 and 86399 inclusive:");
        inPut();
    }

    public static void showLight(int tmp){
        if (0 <= tmp && tmp < 35) {
            System.out.println(ANSI_GREEN+ "Green Light" + ANSI_RESET);
        }
        else if ((35 <= tmp && tmp < 40 ) || (55 <= tmp && tmp < 60)) {
            System.out.println(ANSI_YELLOW + "Yellow Light" + ANSI_RESET);
        }
        else if (40 <= tmp && tmp < 55) {
            System.out.println(ANSI_RED + "Red Light" + ANSI_RESET);
        }
    }

    public static void inPut () throws IOException {
        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String str = bufferedReader.readLine();
                if (isStringNumeric(str)){
                    int seconds = Integer.parseInt(str);

                    if (seconds < 0 ) {
                        System.out.println(errorMsg + " Enter only  positive integers.");
                    }
                    else if (seconds > 86399){
                        System.out.println(errorMsg + " Day is already over.");
                    }
                    else {
                        int tmp = seconds % 60;
                        showLight(tmp);
                        System.out.println("Enter value you are interested in next:");
                    }
                }
                else if ("exit".equalsIgnoreCase(str)) {
                    System.exit(0);
                }
                else {
                    System.out.println(errorMsg
                            + " Please, enter an integer numeric value of seconds!");
                }
            }
        }
    }

    public static boolean isStringNumeric( String str ){
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}


