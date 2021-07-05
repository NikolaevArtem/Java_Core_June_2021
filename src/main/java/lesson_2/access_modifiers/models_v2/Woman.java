package lesson_2.access_modifiers.models_v2;

import lesson_2.access_modifiers.models_v1.Human;

public class Woman extends Human {

  public static void main(String[] args) {
    final Woman woman = new Woman();
    woman.publicMove();
    woman.protectedMove();
//    woman.packageMove();
//    man.privateMove();
  }

}
