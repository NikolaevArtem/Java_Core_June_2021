package homework_1;

public class Main {

  public static void main(String[] args) {
    for (String object : args) {
      if (object.equals("ошибка")) {
        System.out.println("Тревога");
        break;
      }
      else {
        System.out.println(object + ": " + object.length() + " букв");
      }
    }

  }
}