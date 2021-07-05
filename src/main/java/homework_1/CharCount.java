package homework_1;

public class CharCount {
    public static final String RED_BOLD = "\033[1;31m";

    public static void main(String[] args) {
        System.out.println("Count of Char's in words:");
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.out.println(RED_BOLD + "Тревога!");
                break;
            } else {
                System.out.println(arg + ": " + arg.toCharArray().length);
            }
        }
    }

}
