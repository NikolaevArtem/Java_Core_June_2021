package homework_2.homework2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                System.out.print("Choose the mode:\n1 - seconds\n2 - hh:mm:ss\n0 - exit\n-> ");
                int mode = Integer.parseInt(reader.readLine());
                if (mode == 0) {
                    break;
                }
                int seconds = getSeconds(reader, mode);

                printColor(seconds);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.err.println("Entered invalid value!");
        }
        catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    private static int getSeconds(BufferedReader reader, int mode) throws IOException {
        int seconds;
        if (mode == 1) {
            System.out.print("Enter time in seconds: ");
            seconds = Integer.parseInt(reader.readLine());
            if (seconds < 0) {
                throw new IllegalArgumentException("Only positive integers!");
            } else if (seconds >= 86400) {
                throw new IllegalArgumentException("The day is over!");
            }
        } else if(mode == 2) {
            System.out.print("Enter time in the format(hh:mm:ss): ");
            String[] arguments = reader.readLine().split(":");

            int hh = Integer.parseInt(arguments[0]);
            int mm = Integer.parseInt(arguments[1]);
            int ss = Integer.parseInt(arguments[2]);

            if(hh < 0 || hh >= 24 || mm < 0 ||  mm >= 60 || ss < 0 || ss >= 60){
                throw new IllegalArgumentException("Entered time doesn't match the format!");
            }
            seconds = hh * 3600 + mm * 60 + ss;
        } else{
            throw new IllegalArgumentException("Invalid mode type!");
        }
        return seconds;
    }

    public static void printColor(int seconds) throws IllegalArgumentException {
        seconds %= 60;

        if (seconds < 35) {
            System.out.println(ANSI_GREEN + "Green" + ANSI_RESET);
        } else if (seconds < 40 || seconds >= 55) {
            System.out.println(ANSI_YELLOW + "Yellow" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Red" + ANSI_RESET);
        }
    }
}
