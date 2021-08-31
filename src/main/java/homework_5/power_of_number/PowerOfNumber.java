package homework_5.power_of_number;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PowerOfNumber {

    private static final String ERROR = "Only 2 non-negative integers are allowed";

    public void run() {
        int[] array = getInput();
        if (array.length == 2) System.out.println(power(array[0], array[1]));
    }

    private int[] getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, input the values in format: number power");
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 2) {
                int[] result = new int[2];
                for (int i = 0; i < 2; i++) {
                    result[i] = Integer.parseInt(input[i]);
                    if (!isValid(result[i])) {
                        throw new NumberFormatException();
                    }
                }
                return result;
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println(ERROR);
            return new int[0];
        }
    }

    private boolean isValid(int num) {
        return num >= 0;
    }

    private int power(int base, int p) {
        if (p > 0) return base * power(base, p-1);
        if (p < 0) return 1/base * power(base, p+1);
        return 1;
    }


}
