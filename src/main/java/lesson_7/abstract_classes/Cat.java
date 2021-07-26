package lesson_7.abstract_classes;

public class Cat extends AbstractAnimal {

  @Override
  public void sayGoodbye() {
    System.out.println("Cat says meow");
  }

  @Override
  public void sayHi() {
    System.out.println("Cat says meow");
  }

  public void changeName(String name) {
    super.name = name;
  }

  public void printName() {
    System.out.println(super.name);
  }

}
