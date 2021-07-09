package homework_1;

public class CharCount {
    public static void main(String[] args) {
        if (args.length == 0)
        {
            System.out.println("There is no parameters, exit program.");
        }
        else {

        System.out.println("Count of Char's in words:");
        for (String arg : args) {
            if (arg.equals("error")) {
                System.err.println("Alarm!");
                break;
            }
                System.out.println(arg + ": " + arg.length());
        }
        }
    }
}
