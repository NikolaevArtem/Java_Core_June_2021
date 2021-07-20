package lesson_5.init_order;

public class Animal {

  static {
    System.out.println("1. Static animal block");
  }

  {
    System.out.println("3. Dynamic animal block");
  }

  public Animal() {
    System.out.println("4. Animal constructor");
  }

}
