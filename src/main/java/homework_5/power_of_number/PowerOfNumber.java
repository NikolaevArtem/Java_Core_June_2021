package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfNumber {

    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (a < 0 || b < 0) {
                System.out.println("Only 2 non-negative integers are allowed");
                return;
            }
            System.out.println(recursion(a, b));
        } catch (NullPointerException | IOException | NumberFormatException e) {
            System.out.println("Only 2 non-negative integers are allowed");
        }
    }

    private long recursion(int number, int power) {
        if (number == 0) return 0;
        if (number == 1 || power == 0) return 1;
        if (power == 1) return number;
        return number * recursion(number, power - 1);
    }
}
