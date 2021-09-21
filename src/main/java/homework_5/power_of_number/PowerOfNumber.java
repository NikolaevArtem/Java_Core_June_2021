package homework_5.power_of_number;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PowerOfNumber {

    private int number;
    private int power;
    private BigInteger powerOfNumber;

    public static final String ERROR_MESSAGE;
    public static final String ENTER_MESSAGE;

    static {
        ERROR_MESSAGE = "Only 2 non-negative integers are allowed";
        ENTER_MESSAGE = "Enter 2 positive integer numbers: ";
    }

    protected void run() {
        try {
            readConsole();
            if (power == 0) {
                powerOfNumber = BigInteger.ONE;
            } else if (number == 0) {
                powerOfNumber = BigInteger.ZERO;
            } else {
                powerOfNumber = BigInteger.valueOf(number);
                riseNumberToPower(power);
            }
            System.out.printf("The number %s raised to the power %s equals: %s", number, power, powerOfNumber);
        } catch (IOException | NullPointerException e) {
            System.out.println(ERROR_MESSAGE);
        }

    }

    private void riseNumberToPower(int power) {

        if (power != 1) {
            powerOfNumber = powerOfNumber.multiply(BigInteger.valueOf(number));
            power--;
            riseNumberToPower(power);
        }

    }

    private void readConsole() throws IOException, NullPointerException {

        System.out.print(ENTER_MESSAGE);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = bufferedReader.readLine();

            if (inputString.matches("^\\d+\\s\\d+$")) {
                String[] argsArray = inputString.split("\\s+");
                number = Integer.parseInt(argsArray[0]);
                power = Integer.parseInt(argsArray[1]);
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

}