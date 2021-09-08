package lesson_15.java8.functional_interfaces.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

  public static void main(String[] args) {

    Function<Integer, String> function = new Function<Integer, String>() {
      @Override
      public String apply(Integer integer) {
        return integer > 10 ? "yes" : "no";
      }
    };
    Function<Integer, String> functionAsLambda = integer -> integer > 10 ? "yes" : "no";
    System.out.println(functionAsLambda.apply(5));



    BiFunction<String, Integer, String> biFunction =
        new BiFunction<String, Integer, String>() {
          @Override
          public String apply(String s, Integer integer) {
            return s + integer;
          }
        };
    BiFunction<String, Integer, String> biFunctionAsLambda = (str, integer) -> str + integer;

    System.out.println(biFunctionAsLambda.apply("biFunction string ", 100));
  }

}
