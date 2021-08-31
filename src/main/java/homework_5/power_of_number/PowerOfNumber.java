package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PowerOfNumber {

    private int number;
    private int power;
    private BigInteger powerOfNumber;

    public void run() {
        try {
            readFromConsole();
            if (power == 0) {
                powerOfNumber = BigInteger.ONE;
            } else if (number == 0) {
                powerOfNumber = BigInteger.ZERO;
            } else {
                powerOfNumber = BigInteger.valueOf(number);
                countPowerOfNumber(power);
            }
            System.out.printf("Power %s of number %s is: %s", power, number, powerOfNumber);
        } catch (IOException | NullPointerException e) {
            System.out.println("Only 2 non-negative integers are allowed");
        }

    }

    private void countPowerOfNumber(int power) {
        if (power != 1) {
            powerOfNumber = powerOfNumber.multiply(BigInteger.valueOf(number));
            power--;
            countPowerOfNumber(power);
        }
    }

    private void readFromConsole() throws IOException, NullPointerException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter 2 positive integer numbers: ");
            String inputString = reader.readLine();
            if (inputString.matches("^\\d+\\s\\d+$")) {
                String[] paramArray = inputString.split("\\s+");
                number = Integer.parseInt(paramArray[0]);
                power = Integer.parseInt(paramArray[1]);
            } else {
                throw new IOException();
            }
        }
    }

}
