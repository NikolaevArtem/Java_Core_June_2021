package homework_1;

public class Main {

    public static final String RED_COLOR = "\u001B[31m";
    public static final String CLOSE_COLOR = "\u001B[0m";

    public static void main(String[] args) {
        for (String str : args) {
            if (str.equals("ошибка")) {
                System.out.println(RED_COLOR + "Тревога!" + CLOSE_COLOR);
                break;
            }
            System.out.println(str + ": " + str.length() + " букв");
        }


    }
}
