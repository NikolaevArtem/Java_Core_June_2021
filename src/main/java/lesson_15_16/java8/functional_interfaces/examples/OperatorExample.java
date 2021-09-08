package lesson_15_16.java8.functional_interfaces.examples;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExample {

  public static void main(String[] args) {
    final UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
      @Override
      public String apply(String o) {
        return "Hi " + o;
      }
    };
    final UnaryOperator<String> unaryOperatorAsLambda = o -> "Hi " + o;
    System.out.println(unaryOperator.apply("all"));


    final BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {
      @Override
      public String apply(String o, String o2) {
        return o.concat(o2);
      }
    };
    final BinaryOperator<String> binaryOperatorAsLambda = (o, o2) -> o.concat(o2);
    final BinaryOperator<String> binaryOperatorAsMethodReference = String::concat;
    System.out.println(binaryOperator.apply("Hi ", "all"));
  }

}
