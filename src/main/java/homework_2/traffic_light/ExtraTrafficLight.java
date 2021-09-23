package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtraTrafficLight {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void run(int mode) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Choose the mode:\n1 - seconds\n2 - hh:mm:ss\n-> ");
//           int mode = Integer.parseInt(reader.readLine());
            int seconds = getSeconds(reader, mode);

            new PrintColor().print(seconds);
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println(ANSI_RED + "Only non-negative integers is allowed as passed parameter" + ANSI_RESET);
        } catch (IllegalArgumentException e){
            System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);

        }
    }

    private int getSeconds(BufferedReader reader, int mode) throws IOException {
        int seconds;
        if (mode == 1) {
            System.out.print("Enter time in seconds: ");
            seconds = Integer.parseInt(reader.readLine());

        } else if (mode == 2) {
            System.out.print("Enter time in the format(hh:mm:ss): ");
            String[] arguments = reader.readLine().split(":");

            int hh = Integer.parseInt(arguments[0]);
            int mm = Integer.parseInt(arguments[1]);
            int ss = Integer.parseInt(arguments[2]);

            if (hh < 0 || hh >= 24 || mm < 0 || mm >= 60 || ss < 0 || ss >= 60) {
                throw new IllegalArgumentException("Entered time doesn't match the format!");
            }

            seconds = hh * 3600 + mm * 60 + ss;
        } else {
            throw new IllegalArgumentException("Invalid mode type!");
        }
        return seconds;
    }
}
