package lesson_7.abstract_classes;

public abstract class AbstractAnimal {

  public static String className = "AbstractAnimal";
  protected String name = "I'm animal";

  public void sayHi() {
    System.out.println("AbstractAnimal says hi!");
  }

  public abstract void sayGoodbye();

}
