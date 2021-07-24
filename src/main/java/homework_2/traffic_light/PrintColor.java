package homework_2.traffic_light;

public class PrintColor {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    void print(int seconds){

        if (seconds < 0) {
            throw new NumberFormatException();
        }

        if (seconds >= 86400) {
            System.out.println(ANSI_RED + "The day is over!" + ANSI_RESET);
            return;
        }

        seconds %= 60;

        if (seconds < 35) {
            System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
        } else if (seconds < 40 || seconds >= 55) {
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "RED" + ANSI_RESET);
        }
    }
}
