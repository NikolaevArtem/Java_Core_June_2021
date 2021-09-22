package homework_1;

public class CharCount {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void run(String[] args) {
        for (String arg : args) {
            if (arg.equals("error")) {
                System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
                break;
            } else {
                System.out.println(arg + ": " + arg.length() + " letters");
            }
        }
    }
}