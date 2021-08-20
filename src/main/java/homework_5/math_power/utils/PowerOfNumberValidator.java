package homework_5.math_power.utils;

public final class PowerOfNumberValidator {

    public static boolean isValid(String[] args) throws NumberFormatException {
        try {
            return args.length == 2 && Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[1]) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
