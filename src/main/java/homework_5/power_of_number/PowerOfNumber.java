package homework_5.power_of_number;

import homework_2.WrongInputException;

import java.io.IOException;

public class PowerOfNumber {
    private int number;
    private int power;

    public void run() {
        try {
            InputReader inputReader = new InputReader();
            int[] params = inputReader.readParams();
            this.number = params[0];
            this.power = params[1];

            System.out.println(String.valueOf(power(1, 0)));

        } catch (WrongInputException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private long power(int res, int count) {
        if (count == power) {
            return res;
        }
        return power(number * res, ++count);
    }
}
