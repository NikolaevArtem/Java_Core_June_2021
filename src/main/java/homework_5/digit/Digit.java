package homework_5.digit;

public class Digit {

    public static int calculate(long number) {
        return 1 + (number / 10 == 0 ? 0 : calculate(number / 10));
    }
}
