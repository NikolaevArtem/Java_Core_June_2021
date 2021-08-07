package homework_1;

import ConsoleColors.ConsoleColors;

public class ConsolePrinter {
    public static void main(String[] args) {

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                String toPrint = args[i];
                if (toPrint.equalsIgnoreCase("error")) {                                //checking for error
                    System.out.println(ConsoleColors.RED + "Alarm!" + ConsoleColors.RESET);
                    break;
                }

                System.out.println(toPrint + ": " + toPrint.length() + " letter(s)");
            }
        }
    }

}
