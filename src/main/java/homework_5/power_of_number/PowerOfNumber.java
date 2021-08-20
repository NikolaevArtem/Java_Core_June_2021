package homework_5.power_of_number;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PowerOfNumber {

    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

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
        if (b.compareTo(BigInteger.valueOf(0)) == 0) return BigInteger.valueOf(1);
        b = b.subtract(BigInteger.valueOf(1));
        a = a.multiply(pow(a, b));
        return a;
    }

    private boolean isValid(String[] inputStr) {
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
