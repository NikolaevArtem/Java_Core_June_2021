package homework_6.map_problems_generator;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<MapProblemsCollisionGenerator, String> collisionGenerator = new HashMap<>();
        MapProblemsCollisionGenerator firstCollisionKey = new MapProblemsCollisionGenerator(1, "firstValue");
        MapProblemsCollisionGenerator secondCollisionKey = new MapProblemsCollisionGenerator(1, "secondValue");
        MapProblemsCollisionGenerator thirdCollisionKey = new MapProblemsCollisionGenerator(2, "thirdValue");

        collisionGenerator.put(firstCollisionKey, "firstV");
        collisionGenerator.put(secondCollisionKey, "secondV");
        collisionGenerator.put(thirdCollisionKey, "thirdV");

        System.out.println(collisionGenerator.get(firstCollisionKey) + " is not firstV");
        System.out.println(collisionGenerator.get(secondCollisionKey) + " is not secondV");
        System.out.println(collisionGenerator.get(thirdCollisionKey) + " is not thirdV");

        Map<MapProblemsMutableGenerator, String> mutableGenerator = new HashMap<>();
        MapProblemsMutableGenerator firstMutableKey = new MapProblemsMutableGenerator(1, "firstValue");
        MapProblemsMutableGenerator secondMutableKey = new MapProblemsMutableGenerator(2, "thirdValue");

        mutableGenerator.put(firstMutableKey, "firstV");
        mutableGenerator.put(secondMutableKey, "thirdV");

        System.out.println("Before changing " + mutableGenerator.get(firstMutableKey));
        firstMutableKey.setKey(2);
        System.out.println("After changing " + mutableGenerator.get(firstMutableKey));
    }
}
