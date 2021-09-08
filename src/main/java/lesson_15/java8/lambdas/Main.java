package lesson_15.java8.lambdas;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

  // local variables used in lambdas should be final or effectively final
  // fields are fine
  private static int counter = 0;

  public static void main(String[] args) {
    Integer catCounter = 0;
//    catCounter++; makes compiler complain

    Function<Integer, String> function2 =
        integer -> {
          counter++;
          System.out.println(catCounter);
          return integer > 10 ? "yes" : "no";
        };

    System.out.println(function2.apply(5));
  }

  private static void lambdaSyntax() {
    Supplier<String> supplierAsLambda = () -> "Hello"; // without braces here not valid
    Function<String, Integer> function = str -> Integer.parseInt(str); // fine
    Function<String, Integer> function1 = (str) -> Integer.parseInt(str); // fine
    Function<String, Integer> function2 = str -> {
      return Integer.parseInt(str);
    }; // fine too
  }

}
