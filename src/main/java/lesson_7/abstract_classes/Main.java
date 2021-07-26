package lesson_7.abstract_classes;

public class Main {

  public static void main(String[] args) {
    final Cat cat1 = new Cat();
    final Cat cat2 = new Cat();

    cat1.changeName("Murzik");

    cat1.printName();
    cat2.printName();

    final AbstractAnimal animal = new Cat();
  }

}
