package Homework1;

public class Main {
    public static void main(String[] args) {
        final String RED_COLOR = "\u001b[31m";
        final String CLOSE_COLOR = "\u001B[0m";

        for (String s : args) {
            if (s.equals("error")) {
                System.out.println(RED_COLOR + "ALARM" + CLOSE_COLOR);
                break;

            } else {
                System.out.println(s + ": " + s.length() + " letters.");
            }
        }
    }
}

