package lesson_2.access_modifiers;

import lesson_2.access_modifiers.models_v1.Human;

public class Main {

  public static void main(String[] args) {
    final Human human = new Human();
    /**
     * public - доступен везде
     * protected - нельзя так как класс Example1 не находится в пакете model, также не является наследником класса Human
     * package - нельзя так как класс Example1 не находится в пакете model
     * private - можно использовать только на уровне класса, то есть только в самом Human
     */
    human.publicMove();
//    human.packageMove();
//    human.protectedMove();
//    human.privateMove();
  }

}
