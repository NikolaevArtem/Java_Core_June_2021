package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<MapProblemsMutableGenerator, Integer> hash = new HashMap();
        MapProblemsMutableGenerator mapProblemsMutableGenerator = new MapProblemsMutableGenerator(50);
        hash.put(mapProblemsMutableGenerator, 1);
        System.out.println(hash.get(mapProblemsMutableGenerator));
        mapProblemsMutableGenerator.setWeight(25);
        System.out.println(hash.get(mapProblemsMutableGenerator));
    }                                                                                                                                 
}
