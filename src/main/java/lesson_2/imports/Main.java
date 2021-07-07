package lesson_2.imports;

import static lesson_2.imports.models.Animal.staticWalk;
import static lesson_2.imports.models.Human.staticTalk;

import lesson_2.imports.models.Animal;
import lesson_2.imports.models.Human;

public class Main {

  public static void main(String[] args) {
    final Human human = new Human();
    human.talks();
    human.staticTalk(); // Not recommended, получаем статический метод через экземпляр
    Human.staticTalk(); // Good
    staticTalk(); // Good

    final Animal animal = new Animal();
    animal.walk();
    animal.staticWalk(); //Not recommended, получаем статический метод через экземпляр
    Animal.staticWalk(); // Good
    staticWalk(); // Good
  }

}
