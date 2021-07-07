package HomeWork1;

public class Work1 {
    public static void main(String[] args) {

            if(args == null) return;
            for (String str: args){
                if(str.equals("ошибка")){
                    System.out.println("Тревога!");
                    return;
                }
                System.out.println(str + ":" + str.length());
            }


    }
}
