package homework_1;

public class Main {

    private static final String RED = "\u001B[31m";
    private static final String BLACK = "\u001B[0m";

    public static void main(String[] args) {

        for (String str : args) {
            if (str.equals("error")) {
                System.out.println(RED + "Alarm!" + BLACK);
                return;
            }
            System.out.println(str + " " + str.length() + " letters");
        }
    }
}
