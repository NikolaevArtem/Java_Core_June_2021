package lesson_15.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperators {

  // https://habr.com/ru/company/luxoft/blog/270383/
  public static void main(String[] args) {
    streamIntermittentOperations();
  }

  private static void streamCreation() {
    final Stream<Object> stream = new ArrayList<>().stream();
    final Stream<String> stream1 = Stream.of("hi!");
    Arrays.stream(new String[0]);
    final IntStream chars = "Hi!".chars();

    Stream.generate(() -> "a1")
        .limit(100)
        .forEach(System.out::println);
    Stream.iterate(100, i -> i+1)
        .limit(100)
        .forEach(System.out::println);
  }

  private static void streamIntermittentOperations() {
    Stream.of("1", "2", "3", "4", "5")
//        .filter(value -> value.equals("Hi!"))
//        .peek(value -> System.out.println(value))
//        .skip(4)
//        .limit(3)
//        .distinct()
//        .sorted()
//        .map(value -> Integer.parseInt(value))
//        .mapToInt()
//        .flatMap();
        .toArray();

//    System.out.println(Arrays.toString(ints));
  }

  private static void streamTerminalOperations() {
    final Stream<String> stream = Stream.of();
    stream.findFirst();
    stream.findAny();
    stream.count();
    stream.anyMatch("Artem"::equals);
    stream.noneMatch("Artem"::equals);
    stream.allMatch("Artem"::equals);
    stream.min(String::compareTo);
    stream.max(String::compareTo);
    stream.forEach(System.out::println);
    stream.forEachOrdered(System.out::println);
    stream.toArray();
    stream.reduce((s1, s2) -> s1 + s2);
    stream.parallel().sequential().isParallel();
    stream.collect(Collectors.toList());
  }

}
