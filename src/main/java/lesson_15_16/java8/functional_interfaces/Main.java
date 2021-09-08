package lesson_15_16.java8.functional_interfaces;

import java.util.stream.Stream;

public class Main {

//  public static void main(String[] args) {
//    doSmth(str -> System.err.println(str), "Hi!");
//  }
//
//  private static void doSmth(MyFunctionalInterface myFunctionalInterface, String str) {
//    myFunctionalInterface.doSmth(str);
//  }

  public static void main(String[] args) {
    middleWay();
  }

  private static void longWay() {
    final MyFunctionalInterface<String> out = new MyFunctionalInterface<String>() {
      @Override
      public void doSmth(String value) {
        System.out.println(value);
      }
    };

    out.doSmth("Hi!");
    out.doSmth("My");
    out.doSmth("name");
    out.doSmth("is");
    out.doSmth("Artem");
  }

  private static void middleWay() {
    final MyFunctionalInterface<String> out = value -> System.out.println(value);

    out.doSmth("Hi!");
    out.doSmth("My");
    out.doSmth("name");
    out.doSmth("is");
    out.doSmth("Artem");
  }

  private static void fastWay() {
    Stream.of("Hi!", "My", "Name", "Is", "Artem")
        .forEach(System.out::println);
  }

}
