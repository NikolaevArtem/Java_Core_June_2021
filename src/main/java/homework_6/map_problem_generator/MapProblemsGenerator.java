package homework_6.map_problem_generator;

import java.util.HashMap;

public class MapProblemsGenerator {

    public void makeCollision() {

        HashMap<MapProblemsCollisionGenerator, String> mapForCollisions = new HashMap<>();

        MapProblemsCollisionGenerator obj1 = new MapProblemsCollisionGenerator(10);
        MapProblemsCollisionGenerator obj2 = new MapProblemsCollisionGenerator(15);

        mapForCollisions.put(obj1, "field");
        mapForCollisions.put(obj2, "anotherField");
        System.out.println("mapForCollisions = " + mapForCollisions);
        System.out.println(obj1.hashCode() == obj2.hashCode());
    }

    public void makeUnreachedObject() {

        HashMap<MapProblemsMutableGenerator, String> mapForUnreachableObjects = new HashMap<>();

        MapProblemsMutableGenerator obj1 = new MapProblemsMutableGenerator(125);
        MapProblemsMutableGenerator obj2 = new MapProblemsMutableGenerator(126);

        mapForUnreachableObjects.put(obj1, "field");
        mapForUnreachableObjects.put(obj2, "anotherField");
        System.out.println("mapForUnreachableObjects = " + mapForUnreachableObjects);
        System.out.println("mapForUnreachableObjects.get(obj1) = " + mapForUnreachableObjects.get(obj1));

    }
}

