package HomeWork_1;

public class Main {

    public static final String redColor = "\u001B[31m";
    public static final String closeColor = "\u001B[0m";
    public static void main(String[] args) {


            for (String str: args){

                    if(str.equals("ошибка")){
                        System.out.println(redColor+"Тревога!"+closeColor);
                        break;
                    }
                    System.out.println(str + ": " + str.length() + " букв");


            }


    }
}
