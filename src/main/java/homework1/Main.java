package Homework1;

public class Main {
    public static void main(String[] args) {

        for (String s : args) {
            if (s.equals("error")) {
                System.out.println("\u001b[31m" + "ALARM");
                break;

            } else {
                System.out.println(s + ": " + s.length() + " letters.");
            }
        }
    }
}

