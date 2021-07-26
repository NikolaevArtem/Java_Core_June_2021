package lesson_7.interfaces;

import java.util.HashMap;
import lesson_7.interfaces.Tailmovable.Tailhavable;

public class Main {

  public static void main(String[] args) {

    Tailmovable tailmovableButCat = new Cat();
    Tailmovable tailmovableButDog = new Dog();

    tailmovableButCat.moveTail();
    tailmovableButDog.moveTail();

    Sayable sayable = new Cat();
    Tailhavable tailhavable = new Cat();

    new HashMap<>();
  }

}
