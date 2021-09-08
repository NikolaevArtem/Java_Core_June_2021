package lesson_15_16.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    final ArrayList<String> strings = new ArrayList<>();
    strings.add("Hi");
    strings.add("All");
    strings.add("Students");

    final Stream<String> stream = strings.stream()
        .filter(str -> str.contains("i"))
        .map(value -> value.concat(" _ "));

    System.out.println("Initial collection: " + strings);

    final Object[] fromStream = stream.toArray();
    System.out.println("Returned array from stream: " + Arrays.toString(fromStream));
  }


}
