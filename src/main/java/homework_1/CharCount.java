package homework_1;

public class CharCount {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("error")) {
                System.err.println("Alarm!");
                break;
            }
            System.out.println(arg + ": " + arg.length() + " letters");
        }
    }
}
