package homework_5.math_power.utils;

public class Utils {

    public static boolean isValid(String[] args) throws NumberFormatException {
        try {
            return args.length == 2 && Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[1]) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void printMessage(String text) {
        System.out.print(text);
    }
}
