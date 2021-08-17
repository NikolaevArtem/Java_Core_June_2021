package homework_5.exponent;

public class Exponent {
    public static long calculate(int base, int pow) throws InputNegativeBaseArgumentException {
        if (pow < 0) throw new InputNegativeBaseArgumentException();
        return pow == 0 ? 1 : (base*calculate(base, pow-1));
    }
}
