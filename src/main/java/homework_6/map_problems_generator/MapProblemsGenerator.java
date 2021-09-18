package homework_6.map_problems_generator;

import java.util.HashMap;

public class MapProblemsGenerator {
    public void run() {
        HashMap<MapProblemsCollisionGenerator, Integer> collisionMap = new HashMap<>();

        collisionMap.put(new MapProblemsCollisionGenerator("Jess", 23), 1);
        collisionMap.put(new MapProblemsCollisionGenerator("Jess", 15), 2);
        collisionMap.put(new MapProblemsCollisionGenerator("Kate", 15), 3);

        System.out.println("The same name and age. The same hashcode:");
        collisionMap.forEach((key, value) -> System.out.println("hashcode " + key.hashCode() + ": " + key + ", " + value));
        System.out.println();

        HashMap<MapProblemsMutableGenerator, Integer> mutableMap = new HashMap<>();

        MapProblemsMutableGenerator o1 = new MapProblemsMutableGenerator("Pony", 13);
        MapProblemsMutableGenerator o2 = new MapProblemsMutableGenerator("Pony", 15);
        MapProblemsMutableGenerator o3 = new MapProblemsMutableGenerator("Pony", 13);

        mutableMap.put(o1, 4);
        mutableMap.put(o2, 5);
        mutableMap.put(o3, 6);
        mutableMap.forEach((key, value) -> System.out.println("hashcode " + key.hashCode() + ": " + key.toString() + ", " + value));

        System.out.println(o3.equals(o1));
        System.out.println(mutableMap.get(o3));
    }

}