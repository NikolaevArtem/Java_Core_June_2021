package Homework_1;

public class ConsolePrinter {
    public static void main(String[] args) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m\n";
        for (String arg : args) {
            if (arg.equals("error")) {
                System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
                break;
            } else {
                System.out.println(arg + " : " + arg.length() + " letters");
            }
        }
    }
}