package homework_1;

public class Main {

    static final String RED = "\u001b[31m";
    static final String RESET = "\u001b[0m";

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equalsIgnoreCase("ошибка") || arg.equalsIgnoreCase("error")) {
                System.out.println(RED + "Alarm!" + RESET);
                break;
            }

            System.out.println(arg + ": " + arg.length() + " letters");
        }
    }

}
