package lesson_7.override;

public class Main {

  public static void main(String[] args) {
    final Animal animal = new Animal();
    final Animal animalButCat = new Cat(); // позднее связывание
    final Cat cat = new Cat();

    System.out.println(animal.sayHi());
    System.out.println(animalButCat.sayHi());
    System.out.println(cat.sayHi());

    animal.sayGoodbye();
    animalButCat.sayGoodbye();
    cat.sayGoodbye();
//
//    AnimalZoo animalZoo = new AnimalZoo();
//    Animal animal1 = (Animal) animalZoo;
  }

}
