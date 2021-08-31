package homework_6.map_problems_generator;

import homework_6.map_problems_generator.impl.CollidingMapProblemsGeneratorKey;
import homework_6.map_problems_generator.impl.MutableMapProblemsGeneratorKey;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Testing CollidingMapProblemsGeneratorKey:");
        Map<MapProblemsGenerator<String>, Integer> mapWithCollidingKeys = new HashMap<>();
        MapProblemsGenerator<String> myObject1 = new CollidingMapProblemsGeneratorKey<>();
        MapProblemsGenerator<String> myObject2 = new CollidingMapProblemsGeneratorKey<>("2");
        System.out.println("myObject1 == myObject2 = " + (myObject1 == myObject2));
        System.out.println("myObject1.hashCode() == myObject2.hashCode() = " + (myObject1.hashCode() == myObject2.hashCode()));
        mapWithCollidingKeys.put(myObject1, 1);
        mapWithCollidingKeys.put(myObject2, 1);
        System.out.println("mapWithCollidingKeys.size() = " + mapWithCollidingKeys.size());

        System.out.println("\n----\n");

        System.out.println("Testing MutableMapProblemsGeneratorKey:");
        Map<MapProblemsGenerator<String>, Integer> map = new HashMap<>();
        MapProblemsGenerator<String> myObject = new MutableMapProblemsGeneratorKey<>();
        System.out.println("myObject = " + myObject);
        map.put(myObject, 1);
        System.out.println("map.containsKey(myObject) = " + map.containsKey(myObject));
        System.out.println("map.size() = " + map.size());
        System.out.println("Map keys:");
        map.keySet().forEach(System.out::println);
    }
}
