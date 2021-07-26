package lesson_7.interfaces;

public class Cat extends Animal implements Meowable, Tailmovable, Tailmovable.Tailhavable {

  @Override
  public void sayMeow() {
    System.out.println("Meow like a cat");
  }

  @Override
  public void moveTail() {
    System.out.println("Move tail like a cat");
  }

  @Override
  public void saySmth() {
    System.out.println("Meow like a cat");
  }

  @Override
  public void showYourTail() {
    System.out.println("I have a nice cat tail!");
  }

}
