package homework_1;

public class Main {

    public static void main(String[] args) {
        for(String a: args) {
            if (a.equals("ошибка"))
                break;
            System.out.println(a + ": " + a.length());
        }

    }
}
