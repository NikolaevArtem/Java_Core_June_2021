package lesson_2.access_modifiers.models_v1;

public class Man extends Human {

  public static void main(String[] args) {
    final Man man = new Man();
    /**
     * public - доступен везде
     * protected - класс Man является наследником Human или лежит в одном же пакете
     * package - лежит в одном же пакете с классом Human
     * private - вызывать нелья так как private работает только на уровне класса
     */
    man.publicMove();
    man.protectedMove();
    man.packageMove();
//    man.privateMove();
  }

}
