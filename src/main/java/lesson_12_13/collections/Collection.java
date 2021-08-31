package lesson_12_13.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Collection {

  private static final List<String> STRINGS = new ArrayList<>(Arrays.asList("1", "2", "3"));
  private static final ArrayList<String> STRINGS_COPY = new ArrayList<>(Arrays.asList("1", "2"));

  public static void main(String[] args) {
    methodImplementations();
  }

  private static void methodImplementations() {
    System.out.println("--------------query operations--------------");
    System.out.println("strings.size() = " + STRINGS.size());
    System.out.println("strings.isEmpty() = " + STRINGS.isEmpty());
    System.out.println("strings.contains(\"1\") = " + STRINGS.contains("1"));
    final Object[] objects = STRINGS.toArray();
    final String[] strings1 = STRINGS.toArray(new String[0]);

    System.out.println("--------------modification operations--------------");
    STRINGS.add("");
    System.out.println("After add: " + STRINGS);
    STRINGS.remove("");
    System.out.println("After remove: " + STRINGS);

    System.out.println("--------------bulk operations--------------");
    System.out.println("strings.containsAll(STRINGS) = " + STRINGS.containsAll(STRINGS_COPY));
    System.out.println("strings.addAll(STRINGS) = " + STRINGS.addAll(STRINGS_COPY));
    System.out.println(STRINGS);
    System.out.println("strings.removeAll(STRINGS) = " + STRINGS.removeAll(STRINGS_COPY));
    System.out.println(STRINGS);
    System.out.println("strings.removeIf(s -> s.equals(\"1\")) = " + STRINGS.removeIf(s -> s.equals("3")));
    System.out.println(STRINGS);
    System.out.println("strings.retainAll(STRINGS) = " + STRINGS.retainAll(STRINGS_COPY));
    System.out.println(STRINGS);

    System.out.println("--------------other operations--------------");
    final Stream<String> stream = STRINGS.stream();
    final Stream<String> parallelStream = STRINGS.parallelStream();
    STRINGS.clear();
  }

  private static void collectionMethods() {
//    // query operations
//    new java.util.Collection<>().size();
//    new java.util.Collection<>().isEmpty();
//    new java.util.Collection<>().contains("1");
//    new java.util.Collection<>().toArray();
//    new java.util.Collection<>().toArray(new String[0]);
//
//    // modification operations
//    new java.util.Collection<>().add("");
//    new java.util.Collection<>().remove("");
//
//    // bulk operations
//    new java.util.Collection<>().containsAll(STRINGS);
//    new java.util.Collection<>().addAll(STRINGS);
//    new java.util.Collection<>().removeAll(STRINGS);
//    new java.util.Collection<>().removeIf(s -> s.equals("1"));
//    new java.util.Collection<>().retainAll(STRINGS);
//
//    // other
//    new java.util.Collection<>().clear();
//    new java.util.Collection<>().stream();
//    new java.util.Collection<>().parallelStream();
  }

}
