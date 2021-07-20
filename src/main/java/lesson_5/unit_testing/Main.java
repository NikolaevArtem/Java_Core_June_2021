package lesson_5.unit_testing;

public class Main {

  public static void main(String[] args) {
    final String[] s = new CharCounter().returnCountedString(args);
    System.out.println(s);
  }

}
