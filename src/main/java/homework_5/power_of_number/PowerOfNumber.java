package homework_5.power_of_number;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfNumber {

    public void run() {
        int[] input = getInput();
        if (input.length != 2) {
            System.out.println("Only 2 non-negative integers are allowed");
        } else {
            System.out.println(power(input[0], input[1]));
        }
    }

    private static int[] getInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            int[] input = new int[2];
            String[] string = scanner.nextLine().split(" ");
            input[0] = Integer.parseInt(string[0]);
            input[1] = Integer.parseInt(string[1]);

            if (string.length != 2) {
                throw new InputMismatchException();
            }

            if (isValid(input[0]) && isValid(input[1])) {
                return input;
            } else {
                throw new InputMismatchException();
            }
        } catch (NumberFormatException | InputMismatchException | ArrayIndexOutOfBoundsException e) {
            return new int[0];
        }
    }

    private static int power(int number, int divide) {
        if (divide != 0) {
            return number * power(number, divide - 1);
        }
        return 1;
    }

    private static boolean isValid(int number) {
        return number >= 0;
    }
}
