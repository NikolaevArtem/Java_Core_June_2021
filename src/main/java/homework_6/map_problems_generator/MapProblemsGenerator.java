package homework_6.map_problems_generator;

import java.util.HashMap;

public class MapProblemsGenerator {
    public void run1() {
        HashMap<MapProblemsCollisionGenerator, Integer> mapWithCollision = new HashMap<>();

        MapProblemsCollisionGenerator firstObject = new MapProblemsCollisionGenerator("First Object");
        MapProblemsCollisionGenerator secondObject = new MapProblemsCollisionGenerator("Second Object");

        mapWithCollision.put(firstObject, 1);
        mapWithCollision.put(secondObject, 2);

        System.out.println("Collision case in map: ");
        mapWithCollision.keySet().forEach(key -> System.out.println(key.getValue() + " = " + mapWithCollision.get(key)));
        System.out.println("Are the objects equivalent? " + firstObject.equals(secondObject));
        System.out.println("Does the object have the same hashcode? " + (firstObject.hashCode() == secondObject.hashCode()));
    }

    public void run2() {
        HashMap<MapProblemsMutableGenerator, Integer> mapMutable = new HashMap<>();

        MapProblemsMutableGenerator thirdObject = new MapProblemsMutableGenerator("Third Object");
        MapProblemsMutableGenerator fourthObject = new MapProblemsMutableGenerator("Fourth Object");

        mapMutable.put(thirdObject, 3);
        mapMutable.put(fourthObject, 4);

        System.out.println("\nMutable class in map: ");
        mapMutable.entrySet().forEach(System.out::println);
        System.out.println("Trying to get object: " + mapMutable.get(thirdObject));
        System.out.println("Trying to get another object: " + mapMutable.get(fourthObject));

    }
}
