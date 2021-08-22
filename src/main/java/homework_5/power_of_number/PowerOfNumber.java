package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class PowerOfNumber {

    private int number;
    private int power;

    public void run() {
        System.out.println("Please, input number and power.");
        if (validation()) {
            System.out.println(numberToPower(number, power));
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

    private boolean validation() {
        try {
            String inputLine = readInputData();
            if (inputLine == null) {
                return false;
            }
            inputLine = inputLine.trim();
            if (!Pattern.matches("\\d+\\s\\d+", inputLine)) {
                return false;
            }
            String[] values = inputLine.split(" ");
            number = Integer.parseInt(values[0]);
            power = Integer.parseInt(values[1]);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String readInputData() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        }
    }

}
