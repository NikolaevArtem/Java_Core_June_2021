package HomeWork_1;

public class Work1 {
    public static void main(String[] args) {

            if(args == null || args[0].isEmpty()) return;

            for (String str: args){

                    if(str.equals("ошибка")){
                        System.out.println("\u001B[31m"+"Тревога!");
                        return;
                    }
                    System.out.println(str + ": " + str.length() + " букв");


            }


    }
}
