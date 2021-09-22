package homework_6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        MapProblemsCollisionGenerator o1 = new MapProblemsCollisionGenerator(2,"name");
        MapProblemsCollisionGenerator o2 = new MapProblemsCollisionGenerator(3,"name");
        System.out.println(o1.hashCode() == o2.hashCode());
        Map<MapProblemsMutableGenerator, String> map = new HashMap<>();
        MapProblemsMutableGenerator m1 = new MapProblemsMutableGenerator(1);
        MapProblemsMutableGenerator same = new MapProblemsMutableGenerator(1);
        MapProblemsMutableGenerator m2 = new MapProblemsMutableGenerator(2);
        MapProblemsMutableGenerator m3 = new MapProblemsMutableGenerator(3);
        MapProblemsMutableGenerator m4 = new MapProblemsMutableGenerator(4);
        map.put(m1, "1");
        map.put(m2, "2");
        map.put(m3, "3");
        map.put(m4, "4");
        System.out.println(m1.equals(same));
        System.out.println("Trying to get any value by key");
        map.get(m1);
        map.get(m2);
        map.get(m3);
        map.get(m4);
    }
}
