package homework_1;

public class Main {
    public static String StringMaker (String arg){
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
                    break;
                } else {
                    result.append(" букв");
                    break;
                }
            }
            case 2:
            case 3:
            case 4: {
                if (length != 12 && length != 13 && length != 14) {
                    result.append(" буквы");
                    break;
                } else {
                    result.append(" букв");
                    break;
                }
            }
            default: {
                result.append(" букв");
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0)
            return;
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.err.println("Тревога!");
                return;
            } else {
                System.out.println(StringMaker(arg));
            }
        }
    }
}
