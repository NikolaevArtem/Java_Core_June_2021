package homework.task1;
import homework.ConsoleColors;

public class ConsolePrinter {
    public static void main(String[] args){

        if(args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                String toPrint = args[i];
                if (toPrint.matches("error")){                                //checking for error
                    System.out.println(ConsoleColors.RED + "Alarm!" + ConsoleColors.RESET);
                    break;
                }

                System.out.println(toPrint +" : "+ toPrint.length() + " letter(s)");
            }
        }
    }

}
