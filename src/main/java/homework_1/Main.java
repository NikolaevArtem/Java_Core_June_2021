package homework_1;

public class Main {

  public static void main(String[] args) {
    for (String s: args) {
      if (s.equals("ошибка")) {
        System.out.println("Тревога");
        break;
      } else {
        System.out.println(s + ": " + s.length() + " букв");
      }
    }

  }
}
