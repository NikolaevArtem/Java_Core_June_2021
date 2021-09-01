package homework_5.power_of_number;


import java.util.InputMismatchException;
import java.util.Scanner;


class PowerOfNumber {

    public void run() {

        try (Scanner scanner = new Scanner(System.in)) {
            String[] arr = scanner.nextLine().trim().split("\\s");
            int[] numbers = validateNumbers(arr);
            int result = calculateNumberInPower(numbers[0], numbers[1]);

            System.out.println(result);
        } catch (NumberFormatException | InputMismatchException ex) {
            System.out.println("Only two non-negative integer is allowed!");
        }
    }

    public int[] validateNumbers(String[] arr) {
        int[] numbers = new int[2];

        if (arr.length != 2) {
            throw new InputMismatchException();
        }
        numbers[0] = Integer.parseInt(arr[0]);
        numbers[1] = Integer.parseInt(arr[1]);

        for (int i : numbers) {
            if (i < 0) {
                throw new InputMismatchException();
            }
        }

        return numbers;
    }

    public int calculateNumberInPower(int number, int power) {
        if (power == 0) {
            return 1;
        }
        return number * calculateNumberInPower(number, power - 1);
    }
}