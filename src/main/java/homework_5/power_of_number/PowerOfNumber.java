package homework_5.power_of_number;

import base.BaseClazz;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PowerOfNumber extends BaseClazz {

    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    @Override
    public void run() {
        System.out.println("Enter the number and degree");
        System.out.println(printPowResult());
    }

    private String printPowResult() {
        String inputStr = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                inputStr = scanner.nextLine().trim();
            }
        }
        if (isValid(inputStr.split("\\s"))) {
            BigInteger a = new BigInteger(inputStr.split("\\s")[0]);
            BigInteger b = new BigInteger(inputStr.split("\\s")[1]);
            return String.valueOf(pow(a, b));
        } else {
            return ANSI_RED + ERROR_MESSAGE + ANSI_RESET;
        }
    }

    private BigInteger pow(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.valueOf(0)) == 0) {
            return BigInteger.valueOf(1);
        }
        BigInteger newB = b.subtract(BigInteger.valueOf(1));
        return a.multiply(pow(a, newB));
    }

    @Override
    protected boolean isValid(String... inputStr) {
        if (inputStr.length != 2) {
            return false;
        }
        if (!(inputStr[0].chars().allMatch(Character::isDigit) &&
                inputStr[1].chars().allMatch(Character::isDigit))) {
            return false;
        }
        return IntStream.of(Integer.parseInt(inputStr[0])).allMatch(elem -> elem + 1 > 0) &&
                IntStream.of(Integer.parseInt(inputStr[1])).allMatch(elem -> elem + 1 > 0);
    }

}
