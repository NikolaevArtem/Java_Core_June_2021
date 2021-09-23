package homework_6;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<MapProblemsCollisionGenerator, String> map = new HashMap<>();
        MapProblemsCollisionGenerator k1 = new MapProblemsCollisionGenerator(1, "firstKey");
        MapProblemsCollisionGenerator k2 = new MapProblemsCollisionGenerator(2, "secondKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);

    }
}
