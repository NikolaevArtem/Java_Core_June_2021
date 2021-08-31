package lesson_12_13.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;

public class Iterator {

  private static final ArrayList<String> STRINGS = new ArrayList<>(Arrays.asList("1", "2", "3"));

  public static void main(String[] args) {
    // iterable
//    new Iterable<>().iterator();
//    new Iterable<>().spliterator();
//    new Iterable<>().forEach();

    final java.util.Iterator<String> iterator = STRINGS.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      iterator.remove();
    }

    System.out.println(STRINGS);

    final Spliterator<String> spliterator = STRINGS.spliterator();
    final Spliterator<String> stringSpliterator = spliterator.trySplit();

    System.out.println(spliterator.getExactSizeIfKnown());
    System.out.println(stringSpliterator.getExactSizeIfKnown());
  }

}
