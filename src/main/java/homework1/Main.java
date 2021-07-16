package homework1;

public class Main {

    public static void main(String[] args) {

        for (String s : args) {
            if (s.equals("ошибка")) {
                System.out.println("\u001b[31m" + " ТРЕВОГА");
                break;

            } else {
                System.out.println(s + ": " + s.length() + " letters.");
            }
        }
    }
}
