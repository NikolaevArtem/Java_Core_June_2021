package homework_5.power_of_number;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PowerOfNumber {
    private static final String ERROR_MESSAGE = "any problem with input (negative, less/more arguments, string) output: Only 2 non-negative integers are allowed";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String number =  scanner.next();
        String power = scanner.next();
        if (number == null || isNotNumber(number) || power == null || isNotNumber(power)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        int integer = Integer.parseInt(number);
        int intPower = Integer.parseInt(power);
        System.out.println(recursivePower(integer, intPower));
    }

    private boolean isNotNumber(String str) {
        return !Pattern.matches("[0-9]+", str);
    }

    public int recursivePower(int number, int power) {
        if (power == 0) {
            return 1;
        }
        return number * recursivePower(number, --power);
    }
}
