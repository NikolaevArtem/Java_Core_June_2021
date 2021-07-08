package lesson_3.init_blocks;

import lesson_3.init_blocks.model.Call;

public class Main {

  public static void main(String[] args) {
    Call.sayHello();
    System.out.println(Call.staticX);
    // несмотря на то, что еще нет ни одного экземпляра класса, мы уже можем получить доступ к статической переменной

    final Call call = new Call();
    final Call call1 = new Call();

    System.out.println(call.x);
    System.out.println(call.y);
  }

}
