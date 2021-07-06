package Homework1;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) return;
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.err.println("Тревога!");
                return;
            } else {
                String result = arg + ": " + arg.length() + " ";
                switch (arg.length() % 10) {
                    case 1: {
                        if (arg.length() != 11) {
                            result += "буква";
                            break;
                        } else {
                            result += "букв";
                            break;
                        }
                    }
                    case 2:
                    case 3:
                    case 4: {
                        if (arg.length() != 12 && arg.length() != 13 && arg.length() != 14) {
                            result += "буквы";
                            break;
                        } else {
                            result += "букв";
                            break;
                        }
                    }
                    default: {
                        result += "букв";
                        break;
                    }
                }
                System.out.println(result);
            }
        }
    }
}
