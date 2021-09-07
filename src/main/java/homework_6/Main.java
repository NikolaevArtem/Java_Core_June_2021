package homework_6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        HashMap<MapProblemsCollisionGenerator, String> map = new HashMap<>();
        MapProblemsCollisionGenerator key1 = new MapProblemsCollisionGenerator(1, "firstProblem");
        MapProblemsCollisionGenerator key2 = new MapProblemsCollisionGenerator(1, "secondProblem");
        MapProblemsCollisionGenerator key3 = new MapProblemsCollisionGenerator(2, "thirdProblem");

        map.put(key1, "firstValue");
        map.put(key2, "secondValue");
        map.put(key3, "thirdValue");

        System.out.println(map.get(key1));
        System.out.println(map.get(key2));
        System.out.println(map.get(key3));

    }
}
