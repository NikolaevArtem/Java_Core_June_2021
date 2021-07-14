package homework.task2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_1 {
    public static void main(String[] args) {

        int allSeconds = getInput();

        getLight(allSeconds);

    }

    public static int getInput(){
        String numbOfSeconds = null;
        int allSeconds = 0;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            numbOfSeconds = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (numbOfSeconds != null) {
                allSeconds = Integer.parseInt(numbOfSeconds);
            }
        }
        catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED + "Wrong input, only integers are allowed!" + ConsoleColors.RESET);
            System.exit(0);         // I don't know how to manage this place w/o System.exit, but would like to ;)
        }
        return allSeconds;
    }

    public static int getOnlySeconds(int i){        //recursively subtracts full minutes from input
       if (i < 60){
           return i;
       }
       int secs = i - 60;
       if (secs < 60) {
           return secs;
       }
       secs = getOnlySeconds(secs);

       return secs;
    }

    public static void getLight (int i){
        while (true) {
            if (i < 0) {
                System.out.println(ConsoleColors.RED + "Only positive numbers are allowed!" + ConsoleColors.RESET);
                break;
            } else if (i > 86399) {
                System.out.println(ConsoleColors.RED + "To late, the day is over!" + ConsoleColors.RESET);
                break;
            }
            int seconds = getOnlySeconds(i);

            if ((seconds >= 0) && (seconds < 35)) {
                System.out.println(ConsoleColors.GREEN + "Light is GREEN, go you may!" + ConsoleColors.RESET);
                break;
            } else if (((seconds >= 35) && (seconds < 40)) || (seconds >= 55)) {
                System.out.println(ConsoleColors.YELLOW + "Light is YELLOW, be careful, please!" + ConsoleColors.RESET);
                break;
            } else {
                System.out.println(ConsoleColors.RED + "Light is RED, stay where you are!!!" + ConsoleColors.RESET);
                break;
            }
        }
    }

    public static class ConsoleColors{
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
    }
}
