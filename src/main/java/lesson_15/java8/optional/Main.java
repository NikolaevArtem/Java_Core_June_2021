package lesson_15.java8.optional;

import java.util.Optional;

// https://habr.com/ru/post/346782/
public class Main {

//  public static void main(String[] args) {
//    final String str = null;
////    Optional<String> opt = Optional.of(str);
//    Optional<String> opt1 = Optional.ofNullable(str);
//    Optional<String> opt2 = Optional.empty();
//
////    System.out.println("opt.isPresent() = " + opt1.isPresent());
////    opt1.ifPresent(s -> workWithObject(s));
//
////    System.out.println(opt1.orElse("goodbye!"));
////    System.out.println(opt1.orElseGet(() -> "goodbye"));
////    System.out.println(opt1.orElseThrow(RuntimeException::new));
//
//    final String s = opt1
//        .filter(str1 -> str1.equals("Hi"))
//        .orElse("Goodbye!");
//    System.out.println(s);
//
//  }
//
//  private static void workWithObject(String s) {
//    System.out.println(s);
//  }

  public static void main(String[] args) {
    final Cat cat = null;
    final Cat cat2 = new Cat(null);
    final String pretty = Optional
        .ofNullable(cat)
        .map(cat1 -> cat2.getKitten())
        .map(kitten -> kitten.getName())
        .filter(name -> name.equals("Pretty"))
        .orElse("Not pretty :(");
    System.out.println(pretty);

    final Optional<Kitten> kitten = Optional
        .ofNullable(cat)
        .flatMap(cat5 -> operateWithKitten(cat5));
  }

  public static Optional<Kitten> operateWithKitten(Cat cat) {
    return Optional.ofNullable(cat.getKitten());
  }

}
