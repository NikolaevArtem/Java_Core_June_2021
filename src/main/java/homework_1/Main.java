package homework_1;

public class Main {
    public static void main(String[] args) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        for (String arg : args) {
            if (arg.equals("Alarm")) {
                System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
                break;
            } System.out.println(arg + ":" + arg.length());
        }
    }
}
