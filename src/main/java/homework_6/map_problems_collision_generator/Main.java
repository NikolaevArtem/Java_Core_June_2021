package homework_6.map_problems_collision_generator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<MapProblemsMutableGenerator, String> unluckyMap = new HashMap<>();

        MapProblemsMutableGenerator mapProblemsMutableGenerator = new MapProblemsMutableGenerator();
        mapProblemsMutableGenerator.setVal("ложим!");
        unluckyMap.put(mapProblemsMutableGenerator, mapProblemsMutableGenerator.getVal());
        mapProblemsMutableGenerator.setVal("кладем!");

        System.out.println("не можИм! " + unluckyMap.get(mapProblemsMutableGenerator));
    }

}
