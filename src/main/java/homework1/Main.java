package homework1;

public class Main {
    static String word;

    public static String wordAndNumberOfLetters(String word) {


        if (word.equals("ошибка")) {
            return "\u001b[31m" + " ТРЕВОГА";

        } else if (!word.equals("ошибка")) {
            return word + ": " + word.length() + " letters.";

            //added closing String
        } else return "";
    }

    // added psvm
    public static void main(String[] args) {
        System.out.println(wordAndNumberOfLetters(word));
    }

}
