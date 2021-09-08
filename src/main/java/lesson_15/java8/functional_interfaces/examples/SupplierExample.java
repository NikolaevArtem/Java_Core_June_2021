package lesson_15.java8.functional_interfaces.examples;

import java.util.function.Supplier;

public class SupplierExample {

  public static void main(String[] args) {
    Supplier<String> supplier = new Supplier<String>() {
      @Override
      public String get() {
        return "Hello";
      }
    };
    Supplier<String> supplierAsLambda = () -> "Hello";
    System.out.println(supplier.get());
  }

}
