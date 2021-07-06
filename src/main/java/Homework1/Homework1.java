package Homework1;

public class Homework1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.out.println(ANSI_RED + "Тревога!" + ANSI_RESET);
                return;
            }
            int len = arg.length();
            String add = "букв";
            if (len == 1) {
                add = "буква";
            } else if (len > 1 && len < 5) {
                add = "буквы";
            }
            System.out.println(arg + ": " + arg.length() + " " + add);
        }
    }
}
