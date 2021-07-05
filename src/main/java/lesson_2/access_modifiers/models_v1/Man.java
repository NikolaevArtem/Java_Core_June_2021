package lesson_2.access_modifiers.models_v1;

public class Man extends Human {

  public static void main(String[] args) {
    final Man man = new Man();
    man.publicMove();
    man.protectedMove();
    man.packageMove();
//    man.privateMove();
  }

}
