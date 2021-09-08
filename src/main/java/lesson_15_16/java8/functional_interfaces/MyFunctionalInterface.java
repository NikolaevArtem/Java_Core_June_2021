package lesson_15_16.java8.functional_interfaces;

@FunctionalInterface
public interface MyFunctionalInterface <T> {

  void doSmth(T value);

  default void doPrint(T value) {
    System.out.println(value);
  } // does not count, interface is still Functional

}
