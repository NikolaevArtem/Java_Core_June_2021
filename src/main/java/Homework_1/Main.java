package Homework_1;

public class Main {

    private static final String RED_FONT = "\033[0;31m";
    private static final String RESET_FONT = "\033[0m";

    public static void main(String[] args) {
        for (String s : args) {
            if (s.equals("ошибка")) {
                System.out.println(RED_FONT + "Тревога!" + RESET_FONT);
                break;
            } else {
                System.out.println(s + ": " + s.length() + " букв");
            }
        }
    }
}