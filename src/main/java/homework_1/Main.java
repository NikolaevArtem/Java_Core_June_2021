package homework_1;

public class Main {

  public static void main(String[] args) {
    for (String s: args) {
      System.out.println(s + ": " + s.length() + " букв");
      if (s.equals("ошибка")) {
        System.out.println("Тревога");
        break;
        }
    }

  }
}
