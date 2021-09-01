package lesson_15.java8.default_impl_in_interfaces;

public interface Printable {

  default void print() {
    System.out.println("I'm here!");
  }

}
