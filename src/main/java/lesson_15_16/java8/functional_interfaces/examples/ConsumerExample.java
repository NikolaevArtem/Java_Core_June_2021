package lesson_15_16.java8.functional_interfaces.examples;

import java.util.function.Consumer;

public class ConsumerExample {

  public static void main(String[] args) {
    Consumer<String> consumer = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };

    Consumer<String> consumerAsLambda = s -> System.out.println(s);
    Consumer<String> consumerAsMethodReference = System.out::println;

    consumer.accept("hello world");
  }

}
