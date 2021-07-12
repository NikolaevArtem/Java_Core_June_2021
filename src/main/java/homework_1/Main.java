package homework_1;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("Alarm")) {
                System.err.println("Alarm");
                break;
            } System.out.println(arg + ":" + arg.length());
        }
    }
}
