package homework.task1;

public class Task1 {
    public static void main(String[] args){

        if(args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                String toPrint = args[i];
                if (toPrint.matches("error")){                                //checking for error
                    System.out.println(ConsoleCollors.RED + "Alarm!" + ConsoleCollors.RESET);
                    break;
                }

                System.out.println("Argument: " + toPrint +", "+ toPrint.length() + " letter(s)");
            }
        }
    }
    public static class ConsoleCollors{
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Red
        public static final String RED = "\033[0;31m";     // RED
    }
}
