package homework_1;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("error")) {
                System.out.println("\033[0;31m" + "Alarm!" + "\033[0m");
                break;
            }
            System.out.println(arg + ": " + arg.length() + " letters");
        }
    }
}
