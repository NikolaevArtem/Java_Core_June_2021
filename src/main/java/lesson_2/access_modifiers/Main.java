package lesson_2.access_modifiers;

import lesson_2.access_modifiers.models_v1.Human;

public class Main {

  public static void main(String[] args) {
    final Human human = new Human();
    human.publicMove();
//    human.packageMove();
//    human.protectedMove();
//    human.privateMove();
  }

}
