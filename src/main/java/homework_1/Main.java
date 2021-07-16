package homework_1;

public class Main {
    public static String StringMaker(String arg) {
        int length = arg.length();
        StringBuilder result = new StringBuilder();
        result
                .append(arg)
                .append(": ")
                .append(arg.length());
        switch (length % 10) {
            case 1: {
                if (length != 11) {
                    result.append(" буква");
                } else {
                    result.append(" букв");
                }
                break;
            }
            case 2:
            case 3:
            case 4: {
                if (length != 12 && length != 13 && length != 14) {
                    result.append(" буквы");
                } else {
                    result.append(" букв");
                }
                break;
            }
            default: {
                result.append(" букв");
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                final String ANSI_RESET = "\u001B[0m";
                final String ANSI_RED = "\u001B[31m";
                System.out.println(ANSI_RED + "Тревога!" + ANSI_RESET);
                return;
            } else {
                System.out.println(StringMaker(arg));
            }
        }
    }
}
