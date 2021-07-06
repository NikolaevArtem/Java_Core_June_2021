package homework_1;

public class CommandLineArgs {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        for(String str: args){
            if(!str.equals("ошибка")){
                System.out.println(str + ": " + str.length());
            } else {
                System.out.println(ANSI_RED + "Тревога!" + ANSI_RESET);
                break;
            }
        }
    }
}
