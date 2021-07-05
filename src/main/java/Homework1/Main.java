package Homework1;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.out.println(ANSI_RED + "тревога!" + ANSI_RESET);
                return;
            }
            System.out.println(ANSI_YELLOW + arg + ANSI_RESET + ": " +
                    ANSI_GREEN + arg.length() + ANSI_RESET);
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
}
