package homework1;

public class Main {

    public static String wordAndNumber (String word){

        if (word.equals("ошибка")) {
           return "\u001b[31m" + " ТРЕВОГА";
        } else return word + ": " + word.length();

    }

}
