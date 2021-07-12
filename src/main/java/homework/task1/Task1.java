package homework.task1;

public class Task1 {
    public static void main(String[] args){

        if(args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                String toPrint = args[i];
                if (toPrint.matches("error")){                                //checking for error
                    System.out.println("____Alarm!____");
                    System.exit(0);
                }

                System.out.println("Argument: " + toPrint +", "+ toPrint.length() + " letter(s)");
            }
        }
        else System.exit(0);
    }
}
