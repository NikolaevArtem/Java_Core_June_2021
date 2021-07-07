package lesson_2.access_modifiers.models_v2;

import lesson_2.access_modifiers.models_v1.Human;

public class Woman extends Human {

  public static void main(String[] args) {
    final Woman woman = new Woman();
    /**
     * public - доступен везде
     * protected - класс Woman является наследником Human или лежит в одном же пакете
     * package - вызвать нельзя так как класс не лежит в одном пакете с классом Human
     * private - вызывать нелья так как private работает только на уровне класса
     */
    woman.publicMove();
    woman.protectedMove();
//    woman.packageMove();
//    man.privateMove();
  }

}
