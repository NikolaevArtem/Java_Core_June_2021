package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsMutableGenerator, Integer> myMap = new HashMap<>();
        MapProblemsMutableGenerator mutab = new MapProblemsMutableGenerator("first");

        myMap.put(mutab, 100);
        System.out.println(myMap.get(mutab));

        mutab.setSomeString("three");
        System.out.println(myMap.get(mutab));
    }
}
