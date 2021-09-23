package homework_6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        mapCollisionProblems();
        mapMutableProblems();
    }

    public static void mapCollisionProblems() {
        MapProblemsCollisionGenerator mpcg1 = new MapProblemsCollisionGenerator("Generator 1");
        MapProblemsCollisionGenerator mpcg2 = new MapProblemsCollisionGenerator("Generator 2");
        Map<MapProblemsCollisionGenerator, Integer> collisionMap = new HashMap<>();
        collisionMap.put(mpcg1, 1);
        collisionMap.put(mpcg2, 2);
        System.out.println(collisionMap.toString());
    }

    public static void mapMutableProblems() {
        MapProblemsMutableGenerator mpmg1 = new MapProblemsMutableGenerator(1000);
        Map<MapProblemsMutableGenerator, Integer> mutableKeyMap = new HashMap<>();
        mutableKeyMap.put(mpmg1, 1000);
        mpmg1.setGeneratorID(2000);
        System.out.println(mutableKeyMap.containsKey(mpmg1));
    }

}
