package Homework_1;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("error")) {
                System.out.println("\u001B[31m" + "Alarm!" + "\u001B[0m\n");
                break;
            } else {
                System.out.println(arg + " : " + arg.length() + " letters");
            }
        }
            }
        }