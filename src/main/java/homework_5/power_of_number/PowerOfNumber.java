package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PowerOfNumber {

    public void run() {
        System.out.println("Please, input number and power.");
        String input = setInput();
        if (isValid(input)) {
            System.out.println(numberToPower(getNumber(input), getPower(input)));
        } else {
            System.out.println("Only 2 non-negative integers are allowed");
        }
    }

    private int numberToPower(int number, int power) {
        if (power == 0) {
            return 1;
        }
        return number * numberToPower(number, power - 1);
    }

    private boolean isValid(String inputString) {
        if(inputString == null) {
            return false;
        }
        return Pattern.matches("\\d+\\s\\d+", inputString);
    }

    private int getNumber(String inputString) {
        return Integer.parseInt(inputString.split(" ")[0]);
    }

    private int getPower(String inputString) {
        return Integer.parseInt(inputString.split(" ")[1]);
    }

    private String setInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

}
