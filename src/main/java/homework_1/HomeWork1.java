package homework_1;

public class HomeWork1 {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        for(String argument: args){
            if(argument.equals("ошибка")){
                System.out.println(RED + "Тревога!" + RESET);
                break;
            }
            System.out.println(argument + ": " + argument.length() + " букв");
        }
    }
}
