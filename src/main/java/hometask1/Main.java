import java.util.Arrays;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        for (String arg:args) {
            if ("error".equalsIgnoreCase(arg) || "ошибка".equalsIgnoreCase(arg)) {
                System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
                break;
            }
            System.out.println(arg + ": " + arg.length() + " letters");
        }
    }
}
