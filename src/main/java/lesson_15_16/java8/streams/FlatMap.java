package lesson_15_16.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {

  private static final String[][] array2d = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

  public static void main(String[] args) {
    // filter out the a and print out all the characters.
    final Stream<String[]> stream = Arrays.stream(array2d);
//    final Stream<Stream<String>> streamStream = stream.map(value -> Stream.of(value));
    final Stream<String> stream1 = stream.flatMap(value -> Stream.of(value));
    final Object[] objects = stream1.filter(value -> !"a".equals(value))
        .toArray();
    System.out.println(Arrays.toString(objects));



    final Object[] objects1 = Arrays.stream(array2d)
        .flatMap(Arrays::stream)
        .filter(value -> !"a".equals(value))
        .toArray();

    System.out.println(Arrays.toString(objects1));
  }

}
