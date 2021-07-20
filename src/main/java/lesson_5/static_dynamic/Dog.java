package lesson_5.static_dynamic;

public class Dog {

  private static String bark = "Bark bark!";
  private String name = "Grumpy";

  public void doSmth() {
    sayYourName();
    bark();
  }

  public static void doSmthStatically() {
//    sayYourName(); Can't, name is specific to an object
    bark();
  }

  private void sayYourName() {
    System.out.println("I'm " + name);
  }

  private static void bark() {
    System.out.println(bark);
  }

}
