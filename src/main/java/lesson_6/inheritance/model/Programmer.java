package lesson_6.inheritance.model;

public class Programmer extends Man {

  private Cat cat = new Cat();

  @Override
  public Cat getPet() {
    return cat;
  }

  @Override
  public void feedCat() {
    System.out.println("Cat is happy");
  }

}
