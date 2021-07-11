package homework_1;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) return;
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.err.println("Тревога!");
                return;
            } else {
                StringBuilder result = new StringBuilder();
                result
                        .append(arg)
                        .append(": ")
                        .append(arg.length());
                switch (arg.length() % 10) {
                    case 1: {
                        if (arg.length() != 11) {
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
                        if (arg.length() != 12 && arg.length() != 13 && arg.length() != 14) {
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
                System.out.println(result);
            }
        }
    }
}
