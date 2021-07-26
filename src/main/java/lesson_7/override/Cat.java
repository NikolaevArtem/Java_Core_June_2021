package lesson_7.override;

public class Cat extends Animal {

  @Override
  public String sayHi() {
    return "Cat says hi";
  }

  public static void sayGoodbye() {
    System.out.println("Cat says goodbye");
  }

}
