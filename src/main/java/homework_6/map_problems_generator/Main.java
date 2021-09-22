package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<MapProblemsMutableGenerator, Integer> map = new HashMap();
        MapProblemsMutableGenerator mapProblemsMutableGenerator = new MapProblemsMutableGenerator(50);
        map.put(mapProblemsMutableGenerator, 1);
        System.out.println(map.get(mapProblemsMutableGenerator));
        mapProblemsMutableGenerator.setWeight(25);
        System.out.println(map.get(mapProblemsMutableGenerator));
    }                                                                                                                                 
}
