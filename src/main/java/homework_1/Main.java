package homework_1;


public class Main {
    public static void main(String[] args) {

        for (String word : args){
            if (word.equals("Error") | word.equals("error")) break;
            System.out.println(word + ":" + word.length());
        }
    }
}
