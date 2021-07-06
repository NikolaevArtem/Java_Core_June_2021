package homework_1;

public class Homework_1 {
    public static final String ANSI_RED = "\u001B[31m"; // ANSI escape code. Text color: RED.

    public static void main(String[] args) {
        for(String str : args){
            if (str.equals("error")){
                System.out.println(ANSI_RED + "Alarm!"); // Working on Ubuntu.
                break;
            }
            if (str.length() >= 2) {
            System.out.println(str + ": " + str.length() + " letters");
            }
            else System.out.println(str + ": " + str.length() + " letter");
        }
    }
}
