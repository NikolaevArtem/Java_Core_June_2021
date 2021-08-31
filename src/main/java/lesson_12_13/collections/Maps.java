package lesson_12_13.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Maps {

  public static void main(String[] args) {
    mapMethodsImpl();
  }

//    private static void mapMethods() {
//    String key = "key";
//    String value = "value";
//
//    Map<String, String> map = new Map<>();
//
//    map.put(key, value);
//    map.get(key);
//    map.remove(key);
//    final boolean b = map.containsKey(key);
//    final boolean b1 = map.containsValue(value);
//    final int size = map.size();
//    final boolean empty = map.isEmpty();
//    map.putAll(new HashMap<>());
//    map.clear();
//    final Set<String> objects = map.keySet();
//    final Collection<String> values = map.values();
//    final Set<Entry<String, String>> entries = map.entrySet();
//
//    new HashMap<>().entrySet();
//  }

  private static void mapMethodsImpl() {
    String key = "Artem";
    String value = "anikolaev@epam.com";
    String value2 = "anikolaev@yahoo.com";
    Map<String, String> map = new HashMap<>();

    System.out.println("------------put---------------");
    System.out.println("map.put(Artem, anikolaev@epam.com) = " + map.put(key, value));
    System.out.println("map.put(\"Tom\", \"ashandrikov@epam.com\") = " + map.put("Tom", "ashandrikov@epam.com"));
    System.out.println("map.put(Artem, anikolaev@yahoo.com) = " + map.put(key, value2));
    System.out.println("Current map status: " + map);
    System.out.println("------------keySet, values, entrySet---------------");
    final Set<String> strings = map.keySet();
    System.out.println("map.keySet() = " + map.keySet());
    final Collection<String> values = map.values();
    System.out.println("map.values() = " + map.values());
    final Set<Entry<String, String>> entries = map.entrySet();
    System.out.println("map.entrySet() = " + map.entrySet());
    System.out.println("Current map status: " + map);
    System.out.println("------------contains, size, isEmpty---------------");
    System.out.println("map.containsKey(Artem) = " + map.containsKey(key));
    System.out.println("map.containsValue(anikolaev@epam.com) = " + map.containsValue(value));
    System.out.println("map.size() = " + map.size());
    System.out.println("map.isEmpty() = " + map.isEmpty());
    System.out.println("Current map status: " + map);
    System.out.println("------------get & remove---------------");
    System.out.println("map.get(Artem) = " + map.get(key));
    System.out.println("map.remove(Artem) = " + map.remove(key));
    System.out.println("Current map status: " + map);
    System.out.println("------------putAll & clear---------------");
    map.putAll(Collections.singletonMap("Marsel", "mnovikov@epam.com"));
    System.out.println("Current map status after putAll: " + map);
    map.clear();
    System.out.println("Current map status after clear: " + map);
  }

}
