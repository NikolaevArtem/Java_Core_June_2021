package homework_5.digit;

public class Digit {

    public static int getCountOfDigit(long number) {
        return 1 + (number / 10 == 0 ? 0 : getCountOfDigit(number / 10));
    }
}
