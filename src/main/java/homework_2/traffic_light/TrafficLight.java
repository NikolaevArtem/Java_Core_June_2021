package homework_2.traffic_light;

import java.util.Scanner;


public class TrafficLight {
    protected static final String RED_COLOUR = "\u001B[31m";
    protected static final String GREEN_COLOUR = "\u001B[32m";
    protected static final String YELLOW_COLOUR = "\u001B[33m";
    protected static final String RESET_COLOUR = "\u001B[0m";
    protected static final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter! Please, try again";
    int seconds;
    boolean exceptionWasThrown;

    public void run(){
        System.out.println("Enter the time (valid range is from 0 to 86399 ):");
        readAndValidateInput();
        if (exceptionWasThrown) {
            System.out.println(ERR_MSG);
        } else {
            showingTrafficLightColor(seconds);
        }

    }

    protected void readAndValidateInput () throws RuntimeException {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            if (!s.matches("\\d+")) {
                throw new RuntimeException();
            }
            else seconds = Integer.parseInt(s);
        }
        catch (RuntimeException e){
            exceptionWasThrown = true;
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
