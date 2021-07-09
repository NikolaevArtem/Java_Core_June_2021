package homework_1;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equals("ошибка") || arg.equals("error")) {
                System.err.println("Тревога!");
                return;
            }
            System.out.println(arg + ": " + arg.length() + ending(arg.length()));
        }
    }

    static String ending(int len) {
        String word = " букв";
        // First check to avoid creating new variable(less memory)
        // and no more if statements (better performance)
        if (len >= 5 && len < 20) { return word; }
        //
        int n = Math.abs(len) % 100;
        n = n%10;
        if (n > 1 && n < 5) { return word + "ы"; }
        if (n == 1) { return word + "а"; }
        return word;
    }
}
