package homework_1;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка")) {
                System.err.println("Тревога!");
                break;
            }
            System.out.println(arg + ": " + arg.length() + " букв");
        }
    }
}
