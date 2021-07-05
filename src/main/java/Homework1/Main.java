package Homework1;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (!args[i].equals("ошибка")) {
                System.out.println(args[i] + ": " + args[i].length());
            } else {
                System.err.println("тревога!");
                System.exit(0);
            }
    }
}
}
