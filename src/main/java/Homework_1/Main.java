package Homework_1;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("error")) {
                System.out.println("Alarm!");
                break;
            }
            else{
                System.out.println(args[i] + " : " + args[i].length() + " letters");
                }
            }
            }
        }
