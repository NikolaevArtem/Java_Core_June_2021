package homework_1;

public class Homework_1 {
    public static final String ANSI_RED = "\u001B[31m"; // text color: RED.
    public static void main(String[] args) {
        for(String str : args){
            if (str.equals("error")){
                System.out.println(ANSI_RED + "Alarm!"); // text color: RED. Working on Ubuntu.
                break;
            }
            System.out.println(str + ": " + str.length());
        }
    }
}
