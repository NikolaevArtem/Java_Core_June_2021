package homework_1;

public class homework1 {
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
