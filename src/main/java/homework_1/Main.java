package homework_1;

public class Main {

  public static void main(String[] args) {

    for (String i: args) {
      if(i.equals("ошибка")){
        System.out.println("Тревога");
        break;
      }
      System.out.println(i + ": " + i.length());
    }
  }

}
