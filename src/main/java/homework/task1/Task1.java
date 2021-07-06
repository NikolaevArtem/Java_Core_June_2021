package homework.task1;

public class Task1 {
    public static void main(String[] args){

        if(args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                String toPrint = args[i];
                if (toPrint.matches("error")){                                //checking for error
                    System.err.println("Alarm!");
                    System.exit(0);
                }

                toPrint = checkString(toPrint);
                System.out.println("Argument:" + toPrint);
            }
        }
        else System.exit(0);
    }

    public static String checkString(String s){                                   // checking String length, return 8 symbol string

        int sLength = s.length();
        return switch (sLength) {
            case 8 -> s;
            case 7 -> s + "_";
            case 6 -> s + "__";
            case 5 -> s + "___";
            case 4 -> s + "____";
            case 3 -> s + "_____";
            case 2 -> s + "______";
            case 1 -> s + "_______";
            default -> s.substring(0, 7);
        };
    }
}
