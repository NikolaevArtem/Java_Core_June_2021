package lesson_15_16.java8.functional_interfaces.examples;

import java.util.function.Predicate;

public class PredicateExample {

  public static void main(String[] args) {
    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer > 5;
      }
    };

    Predicate<Integer> predicateAsLambda = integer -> integer > 5;

    System.out.println(predicate.test(5));
    System.out.println(predicate.test(-3));
  }

}
