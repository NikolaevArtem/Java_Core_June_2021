package homework_1;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            if (!arg.equals("error")){
                System.out.println(arg + ": " + arg.length() + " letters");
            } else{
                System.err.println("Alarm!");
                break;
            }
        }
    }
}
