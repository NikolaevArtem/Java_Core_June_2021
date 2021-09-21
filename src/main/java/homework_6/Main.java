package homework_6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MapProblemsMutableGenerator obj1 = new MapProblemsMutableGenerator("Jorge", true, 23);
        MapProblemsMutableGenerator obj2 = new MapProblemsMutableGenerator("Ivan", true, 28);

        Map<MapProblemsMutableGenerator, String> map = new HashMap<>();
        map.put(obj1, "EN");
        map.put(obj2, "NL");

        System.out.println("value obj 1 - " + map.get(obj1));
        System.out.println("value obj 2 - " + map.get(obj2));

        obj1.setName("Jorge Jr");
        System.out.println(map.values());
        System.out.println();

        System.out.println("value obj 1 - " + map.get(obj1));
        System.out.println("value obj 2 - " + map.get(obj2));

    }

}
