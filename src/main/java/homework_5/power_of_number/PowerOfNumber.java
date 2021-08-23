package homework_5.power_of_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PowerOfNumber {
    private final String ERR_MSG = "Only 2 non-negative integers are allowed";

    public void run() {
        System.out.println("Enter the number and degree, please, only 2 non-negative integers are allowed:");
        String[] input = getInput();
        if (isValid(input)) {
            BigInteger val = BigInteger.valueOf(Integer.parseInt(input[0]));
            BigInteger pow = BigInteger.valueOf(Integer.parseInt(input[1]));
            System.out.println(recPow(val, pow));
        }
    }


    private String[] getInput() {
        String[] result = new String[2];            //only 2 arguments are allowed
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String rawInput = reader.readLine().trim();
            String[] toMeasure = rawInput.split("\\s");
            if (toMeasure.length != 2) {
                System.out.println(ERR_MSG);
                return result;
            } else {
                result = rawInput.split("\\s");
            }

        }
        catch (IOException e) {
            System.out.println(ERR_MSG);
        }
        return result;
    }

    private boolean isValid(String[] input) {
        if (input[0] != null && input[1] != null) {
            if (input[0].chars().allMatch(Character::isDigit) &&
                    input[1].chars().allMatch(Character::isDigit)) {
                return true;
            }
            System.out.println(ERR_MSG);
        }
        return false;
    }

    public BigInteger recPow(BigInteger val, BigInteger pow) {

        if (pow.compareTo(BigInteger.valueOf(0)) == 0) {
            return BigInteger.valueOf(1);
        }
        pow = pow.subtract(BigInteger.valueOf(1));
        val = val.multiply(recPow(val, pow));               //recursion

        return val;
    }

}
