package homework_5.power_of_number;

import java.util.Scanner;

public class PowerOfNumber {

    private int number;
    private int power;
    private boolean validInput = true;

    public void run() {
        System.out.print("Enter number and power: ");
        getInput();
        if (validInput) {
            System.out.println(power(number, power));
        }
    }

    private void getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            String tail = parseInput(scanner);
            validateInput(tail);
        } catch (RuntimeException e) {
            System.out.println("Only 2 non-negative integers are allowed");
            validInput = false;
        }
    }

    private String parseInput(Scanner scanner) {
        number = scanner.nextInt();
        power = scanner.nextInt();

        if (scanner.hasNextLine()) {
            return scanner.nextLine().trim();
        } else {
            return "";
        }
    }

    private void validateInput(String tail) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (power < 0) {
            throw new IllegalArgumentException();
        }
        if (!tail.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private int power(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        return num * power(num, pow - 1);
    }
}
