package lesson_12_13.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class List {

  // O(1) get()
  // O(1) add()
  // O(n) remove()
  // Медленный, когда вставляются и удаляются элементы из «середины» списка
  // Позволяет хранить любые значения в том числе null;
  // Не синхронизирован.
  private static final ArrayList<String> STRINGS = new ArrayList<>(Arrays.asList("1", "2", "3"));
  private static final LinkedList<String> STRINGS_LINKED_LIST = new LinkedList<>(Arrays.asList("1", "2", "3"));

  public static void main(String[] args) {
    final LinkedList<String> strings = new LinkedList<>();
    strings.add("1");
    strings.add("2");
    strings.add("3");
  }

  private static void listImplementation() {
    // array inside, mod count, dynamic size
    final String s = STRINGS.get(0);
    STRINGS.set(0, "11");
    STRINGS.add("4");
    STRINGS.add(1, "12");
    STRINGS.remove("12");
    STRINGS.addAll(Collections.singletonList("4"));
    STRINGS.indexOf("3");
    STRINGS.lastIndexOf("3");
    final ListIterator<String> stringListIterator = STRINGS.listIterator();
    final ListIterator<String> stringListIterator1 = STRINGS.listIterator(3);
    final java.util.List<String> strings1 = STRINGS.subList(0, 2);
  }

  private static void extraArrayListMethods() {
    STRINGS.ensureCapacity(5);
    STRINGS.trimToSize();
  }

  private static void listInterfaceMethods() {
//    new java.util.List<>().get(0);
//    new java.util.List<>().set(0, "11");
//    new java.util.List<>().add("4");
//    new java.util.List<>().add(1, "12");
//    new java.util.List<>().remove("12");
//    new java.util.List<>().addAll(Collections.singletonList("4"));
//    new java.util.List<>().indexOf("3");
//    new java.util.List<>().lastIndexOf("3");
//    final ListIterator<Object> stringListIterator = new java.util.List<>().listIterator();
//    final ListIterator<Object> stringListIterator1 = new java.util.List<>().listIterator(3);
//    final java.util.List<Object> strings1 = new java.util.List<>().subList(0, 2);
  }


}
