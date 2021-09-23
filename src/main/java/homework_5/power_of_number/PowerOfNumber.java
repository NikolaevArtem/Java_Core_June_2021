package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfNumber {

    private int num;
    private int pow;

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            if (valid(reader.readLine())) {
                System.out.println(power(num, pow));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static int power(int base, int powerRaised) {
        if (powerRaised != 0) {
            return (base * power(base, powerRaised - 1));
        } else {
            return 1;
        }
    }

    private boolean valid(String s) {

        if (s == null) {
            System.out.println("Error: args is null");
            return false;
        }

        String[] inputArgs = s.split(" ");

        if (inputArgs.length < 2) {
            System.out.println("Error: less when 2 args");
            return false;
        }

        String mode;

        try {
            num = Integer.parseInt(inputArgs[0]);
            pow = Integer.parseInt(inputArgs[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: first and second args must be integer");
            return false;
        }

        if (num < 0 || pow < 0) {
            System.out.println("Error: first and second args must be positive");
            return false;
        }

        return true;
    }
}

