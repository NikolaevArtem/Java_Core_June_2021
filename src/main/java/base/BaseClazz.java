package base;

import java.math.BigInteger;
import java.util.stream.IntStream;

public abstract class BaseClazz {

    protected static final String ANSI_RESET = "\033[0m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    protected static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    protected static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public abstract void run();

    protected boolean isValid(String... arg) {
        if (arg[0].split("\\s").length > 1) {
            return false;
        }
        if (!arg[0].chars().allMatch(Character::isDigit)) {
            return false;
        }

        return new BigInteger(arg[0]).compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0 &&
                IntStream.of(Integer.parseInt(arg[0])).allMatch(elem -> elem + 1 > 0);
    }

}
