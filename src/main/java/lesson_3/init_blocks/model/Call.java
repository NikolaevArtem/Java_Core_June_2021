package lesson_3.init_blocks.model;

public class Call {

  public static int staticX;
  public int x;
  public int y;

  static {
    // при первом запросе к классу
    System.out.println("1. Static init block, staticX = 5");
    staticX = 5;
  }

  {
    // при каждой инициализации обьекта
    System.out.println("2. Dynamic init block, x = 6");
    x = 6;
  }

  public Call() {
    System.out.println("3. Constructor, y = 7");
    y = 7;
  }

  public static void sayHello() {
    System.out.println("Hello!");
  }

}
