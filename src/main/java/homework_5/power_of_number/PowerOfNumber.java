package homework_5.power_of_number;

import homework_2.ConsoleSafeReader;

public class PowerOfNumber {

    public void run() {
        System.out.println("Enter a number and a power: ");
        String input = ConsoleSafeReader.read().trim();
        if (input.matches("\\d+\\s+\\d+")) {
            calculateResult(input);
        } else {
            System.out.println("Only 2 non-negative integers are allowed");
        }
    }

    private void calculateResult(String input) {
        int num = Integer.parseInt(input.split("\\s+")[0]);
        int power = Integer.parseInt(input.split("\\s+")[1]);
        System.out.println(recPow(num, power));
    }

    private int recPow(int n, int power) {
        if (power == 0) {
            return 1;
        } else {
            return n * recPow(n, power - 1);
        }
    }
}
