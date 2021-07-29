package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    private void errorMsg(){
        System.out.println("Only 1 non-negative integer is allowed as passed parameter.");
    }

    public int input() {
        int seconds = -1;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            seconds = validate(str);
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return seconds;
    }

    private int validate(String str) {
        int tmp = -1;

        if (isStringNumeric(str)) {
            int seconds = Integer.parseInt(str);
            if (seconds < 0) {
                errorMsg();
            } else if (seconds > 86399) {
                System.out.println("The day is over");
            } else {
                tmp = seconds % 60;
            }
        } else {
            errorMsg();
        }
        return tmp;
    }

    private boolean isStringNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
