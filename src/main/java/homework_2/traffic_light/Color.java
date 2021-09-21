package homework_2.traffic_light;

public class Color {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void green() {
        System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
    }

    public static void yellow() {
        System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
    }

    public static void red() {
        System.out.println(ANSI_RED + "RED" + ANSI_RESET);
    }

    public static void error() {
        System.out.println("The day is over");
    }
}
