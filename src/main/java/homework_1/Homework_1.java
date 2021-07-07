package homework_1;

public class Homework_1 {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.out.println(ANSI_RED + "Тревога!" + ANSI_RESET);
                return;
            }
            print(arg);
        }
    }

    static String ending(int len) {
        String word = "букв";
        switch (len % 100) {
            case 1: return word + "а";
            case 2:
            case 3:
            case 4: return word + "ы";
            default: return word;
        }
    }

    static void print(String str) {
        int len = str.length();
        System.out.println(str + ": " + len + " " + ending(len));
    }
}
