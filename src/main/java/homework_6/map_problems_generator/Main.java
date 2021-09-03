package homework_6.map_problems_generator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<MapProblemsMutableGenerator, String> map = new HashMap<>();
        MapProblemsMutableGenerator object1 = new MapProblemsMutableGenerator(1);
        MapProblemsMutableGenerator object2 = new MapProblemsMutableGenerator(1);

        System.out.println("Check equals: " + object1.equals(object2));

        map.put(object1, "some value");
        System.out.println("Try to get: " + map.get(object1));
    }

}
