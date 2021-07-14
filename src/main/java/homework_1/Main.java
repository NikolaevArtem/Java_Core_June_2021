package homework_1;

public class Main {

    public static void main(String[] args) {
        final String RED_FONT = "\033[0;31m";
        final String RESET_FONT = "\033[0m";

        for (String arg : args) {
            if (arg.equals("error")) {
                System.out.println(RED_FONT + "Alarm!" + RESET_FONT);
                break;
            } else {
                System.out.println(arg + ": " + arg.length() + " letters");
            }
        }
    }
}
