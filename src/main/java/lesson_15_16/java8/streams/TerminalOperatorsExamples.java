package lesson_15_16.java8.streams;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://habr.com/ru/company/luxoft/blog/270383/
public class TerminalOperatorsExamples {

  private static final String[] array = {"Artem", "Nikolaev", "Is", "My", "Name"};
  private static final String[] intArray = {"1", "2", "3", "4", "5"};


  public static void main(String[] args) {
    System.out.println("-----------Streams terminal operations--------------");
    System.out.println("Initial elements - " + Arrays.toString(array));
    final Optional<String> first = stream(array).findFirst();
    System.out.println("first.get() = " + first.get());
    final Optional<String> any = stream(array).findAny();
    System.out.println("any.get() = " + any.get());
    final long count = stream(array).count();
    System.out.println("count = " + count);
    final boolean anyMatch = stream(array).anyMatch("Artem"::equals);
    System.out.println("anyMatch = " + anyMatch);
    final boolean noneMatch = stream(array).noneMatch("Artem"::equals);
    System.out.println("noneMatch = " + noneMatch);
    final boolean allMatch = stream(array).allMatch("Artem"::equals);
    System.out.println("allMatch = " + allMatch);
    final Optional<String> min = stream(array).min(String::compareTo);
    System.out.println("min.get() = " + min.get());
    final Optional<String> max = stream(array).max(String::compareTo);
    System.out.println("max.get() = " + max.get());
    stream(array).forEach(System.out::print);
    System.out.println();
    stream(array).forEachOrdered(System.out::print); // guarantees order in parallel execution
    System.out.println();
    final Object[] objects = stream(array).toArray();
    System.out.println("Arrays.toString(objects) = " + Arrays.toString(objects));
    final Optional<String> reduce = stream(intArray).reduce(((s1, s2) -> s1 + s2));
    System.out.println("reduce.get() = " + reduce.get());
    final boolean isParallel = stream(array).parallel().isParallel();
    System.out.println("isParallel = " + isParallel);
    final boolean isParallel1 = stream(array).parallel().sequential().isParallel();
    System.out.println("isParallel1 = " + isParallel1);

    System.out.println("-----------Streams collect & Collectors--------------");
    // https://www.baeldung.com/java-8-collectors
    final List<String> list = stream(array).collect(Collectors.toList());
    System.out.println("list = " + list);
    final Map<String, Integer> map = stream(array).collect(Collectors.toMap(str -> str, String::length));
    System.out.println("map = " + map);
    final LinkedList<String> linkedList = stream(array).collect(Collectors.toCollection(LinkedList::new));
    System.out.println("linkedList = " + linkedList);
    final String joining = stream(array).collect(Collectors.joining(", "));
    System.out.println("joining = " + joining);
    final Long counting = stream(array).collect(Collectors.counting());
    System.out.println("counting = " + counting);
    final Map<Object, List<String>> groupingBy = stream(array).collect(Collectors.groupingBy(s -> s.equals("Artem")));
    System.out.println("groupingBy = " + groupingBy);
//
    System.out.println("-----------Number streams terminal operations--------------");
    System.out.println("Initial elements - " + Arrays.toString(intArray));
    final int sum = stream(intArray).mapToInt(Integer::parseInt).sum();
    System.out.println("sum = " + sum);
    final OptionalDouble average = stream(intArray).mapToInt(Integer::parseInt).average();
    System.out.println("average = " + average);
    final Stream<String> mapToObj = stream(intArray).mapToInt(Integer::parseInt).mapToObj(String::valueOf);
    System.out.println("Arrays.toString(mapToObj.toArray()) = " + Arrays.toString(mapToObj.toArray()));
  }

}
